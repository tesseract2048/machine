package com.qunar.coach.machine.webapp.controller;

/**
 * Created by niuli on 15-10-21.
 */

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.mode.StationType;
import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.CoachTicket;
import com.qunar.coach.machine.core.model.PrintInfo;
import com.qunar.coach.machine.core.model.ResponseCode;
import com.qunar.coach.machine.dao.model.tables.pojos.IdentityCard;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.service.PersonIDService;
import com.qunar.coach.machine.service.TicketService;
import com.qunar.coach.machine.service.facade.TicketBeanFacade;
import com.qunar.coach.machine.webapp.constant.RequestParameter;
import com.qunar.coach.machine.webapp.mocker.CoachTicketMocker;

/**
 * Created by niuli on 15-10-21.
 */
@Controller
@RequestMapping(value = "/api/v1/ticket")
public class TicketController {
    @Autowired
    private PersonIDService personIDService;

    @Resource
    private MachineService machineService;

    private TicketBeanFacade ticketBeanFacade = new TicketBeanFacade();

    private int PRINT_TIMEOUT = 3000;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/printStart", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<PrintInfo> printStart(
        @RequestParam(value = RequestParameter.DEVICE_ID,
            required = true, defaultValue = "") String deviceId,
        @RequestParam(value = RequestParameter.TICKET_ID,
            required = true, defaultValue = "") String ticketId) {
        //1. Lock ticket id, that means send http message to
        // siteProxy to lock ticket by ticket id.
        //2. Update mysql state.
        //3. echo ticket id back, append the timeout.

        PrintInfo printInfo = new PrintInfo();
        printInfo.setStartTime(System.currentTimeMillis());
        printInfo.setTimeOut(PRINT_TIMEOUT);
        printInfo.setTicketId(ticketId);
        return APIResponse.success(printInfo);
    }

    @RequestMapping(value = "/printDone", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<PrintInfo> getVideoBeanList(
            @RequestParam(value = RequestParameter.DEVICE_ID,
                    required = true, defaultValue = "") String machineId,
            @RequestParam(value = RequestParameter.TICKET_ID,
                    required = true, defaultValue = "") String ticketId) {

        PrintInfo printInfo = new PrintInfo();
        printInfo.setStartTime(System.currentTimeMillis());
        printInfo.setTimeOut(PRINT_TIMEOUT);
        printInfo.setTicketId(ticketId);
        /**
         * 1. callback to siteProxy.
         * 2. update ticket status in mysql.
         * 3. write back status code.
         */
        return APIResponse.success();

    }

    @RequestMapping(value = "/test_query_ticket", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<ShenZhenTicketPrintBean>> getTicket(
        @RequestParam(value = RequestParameter.DEVICE_ID, required = true, defaultValue = "") String machineId,
        @RequestParam(value = "id", required = true) String cardId,
        @RequestParam(value = "name", required = true) String name,
        @RequestParam(value = "nation", required = true) String nation,
        @RequestParam(value = "birthday", required = true) String birthDate,
        @RequestParam(value = "address", required = true) String address,
        @RequestParam(value = "gender", required = true) String sex,
        @RequestParam(value = "passWord", required = false) String passWord) {
        System.out.println("[query_ticket] id: " + cardId);
        System.out.println("[query_ticket] name: " + name);
        System.out.println("[query_ticket] nation: " + nation);
        System.out.println("[query_ticket] birthDate: " + birthDate);
        System.out.println("[query_ticket] address: " + address);
        System.out.println("[query_ticket] sex: " + sex);
        System.out.println("[query_ticket] passWord: " + passWord);

        /**
         * 1. update id card into mysql, that means first check the id card exist, add the card info if not exist.
         * 2. get ticket info from siteProxy, if no info, write back empty.
         * 3. generate ticket info list.
         * 4. rank and filter the info list to adapt every station, find the tickets necessary to feed back.
         * 5. record the user action into user action table.
         * 6. record the ticket info into ticket table of mysql.
         * 7. write back.
         * cautious:
         * 1. maybe the request sent to siteProxy is failed due to connection timeout or other error,
         * we should in charge of the retry way, neither too often nor too few to obtain the response time, use 3 times
         * to test, then we should optimize the retry times and timeout after experiment.
         * 2. ticket status should be right. we plan to use consistent hash table to obtain the data consistent.
         * */

        //personIDService.addPerson(identityCard);

        // facade ticket bean.
        List<CoachTicket> cts = CoachTicketMocker.mockList();

        List<ShenZhenTicketPrintBean> shenZhenTicketPrintBeans = new ArrayList<>();
        for (CoachTicket ct: cts){
            ShenZhenTicketPrintBean sztpb = (ShenZhenTicketPrintBean)ticketBeanFacade.facade(StationType.SHENZHEN, ct);
            shenZhenTicketPrintBeans.add(sztpb);
        }

        return APIResponse.success(shenZhenTicketPrintBeans);
    }

    @RequestMapping(value = "/query_ticket_by_card", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<CoachTicket>> getTicketV2(
            IdentityCard identityCard,
            @RequestParam(value = RequestParameter.DEVICE_ID, required = true, defaultValue = "") String deviceId,
            @RequestParam(value = RequestParameter.KEY, required = false, defaultValue = "") String key){
        System.out.println("[query_ticket] id: " + identityCard.getCardId());
        System.out.println("[query_ticket] name: " + identityCard.getName());
        System.out.println("[query_ticket] nation: " + identityCard.getNation());
        System.out.println("[query_ticket] birthDate: " + identityCard.getBirthDate());
        System.out.println("[query_ticket] address: " + identityCard.getAddress());
        System.out.println("[query_ticket] sex: " + identityCard.getSex());
        System.out.println("[query_ticket] key: " + key);
        //System.out.println("[query_ticket] passWord: " + passWord);
        if (!machineService.isDeviceExist(deviceId)){
            return APIResponse.failed(ResponseCode.INVALID_MACHINE);
        }

        /**
         * 1. update id card into mysql, that means first check the id card exist, add the card info if not exist.
         * 2. get ticket info from siteProxy, if no info, write back empty.
         * 3. generate ticket info list.
         * 4. rank and filter the info list to adapt every station, find the tickets necessary to feed back.
         * 5. record the user action into user action table.
         * 6. record the ticket info into ticket table of mysql.
         * 7. write back.
         * cautious:
         * 1. maybe the request sent to siteProxy is failed due to connection timeout or other error,
         * we should in charge of the retry way, neither too often nor too few to obtain the response time, use 3 times
         * to test, then we should optimize the retry times and timeout after experiment.
         * 2. ticket status should be right. we plan to use consistent hash table to obtain the data consistent.
         * */

        personIDService.addPerson(identityCard);
        //Todo, mock data
        return APIResponse.success(CoachTicketMocker.mockList());
    }


    @RequestMapping(value = "/query_by_number", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<ShenZhenTicketPrintBean>> fetchTicket(
        @RequestParam(value = RequestParameter.DEVICE_ID,
            required = true, defaultValue = "") String deviceId,
        @RequestParam(value = RequestParameter.FETCH_NUMBER,
            required = true, defaultValue = "") String fetchNumber) {

        if (!machineService.isDeviceExist(deviceId)){
            return APIResponse.failed(ResponseCode.INVALID_MACHINE);
        }

        //personIDService.addPerson(identityCard);

        // facade ticket bean.
        List<CoachTicket> coachTickets = CoachTicketMocker.mockList();

        List<ShenZhenTicketPrintBean> shenZhenTicketPrintBeans = new ArrayList<>();
        for (CoachTicket coachTicket: coachTickets){
            ShenZhenTicketPrintBean sztpb =
                    (ShenZhenTicketPrintBean)ticketBeanFacade.facade(StationType.SHENZHEN, coachTicket);
            shenZhenTicketPrintBeans.add(sztpb);
        }

        return APIResponse.success(shenZhenTicketPrintBeans);

        /**
         * 1. update id card into mysql, that means first check the id card exist, add the card info if not exist.
         * 2. get ticket info from siteProxy, if no info, write back empty.
         * 3. generate ticket info list.
         * 4. rank and filter the info list to adapt every station, find the tickets necessary to feed back.
         * 5. record the user action into user action table.
         * 6. record the ticket info into ticket table of mysql.
         * 7. write back.
         * cautious:
         * 1. maybe the request sent to siteProxy is failed due to connection timeout or other error,
         * we should in charge of the retry way, neither too often nor too few to obtain the response time, use 3 times
         * to test, then we should optimize the retry times and timeout after experiment.
         * 2. ticket status should be right. we plan to use consistent hash table to obtain the data consistent.
         * */
    }

}