package com.qunar.coach.machine.webapp.controller;

/**
 * Created by niuli on 15-10-21.
 */

import javax.annotation.Resource;

import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.mode.StationType;
import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.CoachTicket;
import com.qunar.coach.machine.core.model.PrintInfo;
import com.qunar.coach.machine.dao.model.tables.pojos.IdentityCard;
import com.qunar.coach.machine.service.PersonIDService;
import com.qunar.coach.machine.service.TicketService;
import com.qunar.coach.machine.service.facade.TicketBeanFacade;
import com.qunar.coach.machine.webapp.mocker.CoachTicketMocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qunar.coach.machine.core.model.TicketBean;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.MachineRequestParameter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by niuli on 15-10-21.
 */
@Controller
@RequestMapping(value = "/api/ticket")
public class TicketController {

    @Autowired
    private PersonIDService personIDService;

    @Resource
    private MachineService machineService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/printStart", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<PrintInfo> printStart(
        @RequestParam(value = MachineRequestParameter.MACHINE_ID,
            required = true, defaultValue = "") String machineId,
        @RequestParam(value = MachineRequestParameter.TICKET_ID,
            required = true, defaultValue = "") int ticketId) {
        //Todo: Mock Data
        APIResponse<PrintInfo> infoAPIResponse = new APIResponse<>();

        PrintInfo printInfo = new PrintInfo();
        printInfo.setStartTime(System.currentTimeMillis());
        printInfo.setTimeOut(300);
        printInfo.setTicketId(ticketId);
        infoAPIResponse.setT(printInfo);

        return infoAPIResponse;
    }

    @RequestMapping(value = "/printDone", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<PrintInfo> getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = true, defaultValue = "") String machineId,
            @RequestParam(value = MachineRequestParameter.TICKET_ID,
                    required = true, defaultValue = "") String ticketId) {
        /**
         * 1. callback to siteProxy.
         * 2. update ticket status in mysql.
         * 3. write back status code.
         */
        //Todo: Mock Data
        return new APIResponse<>();
    }

    @RequestMapping(value = "/test_query_ticket", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<ShenZhenTicketPrintBean>> getTicket(
        @RequestParam(value = MachineRequestParameter.MACHINE_ID, required = true, defaultValue = "") String machineId,
        @RequestParam(value = "cardId", required = true) String cardId,
        @RequestParam(value = "name", required = true) String name,
        @RequestParam(value = "nation", required = true) String nation,
        @RequestParam(value = "birthDate", required = true) String birthDate,
        @RequestParam(value = "address", required = true) String address,
        @RequestParam(value = "sex", required = true) String sex,
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
        APIResponse<List<ShenZhenTicketPrintBean>> apiResponse = new APIResponse<>();

        // facade ticket bean.
        List<CoachTicket> cts = CoachTicketMocker.mockList();

        List<ShenZhenTicketPrintBean> shenZhenTicketPrintBeans = new ArrayList<>();
        for (CoachTicket ct: cts){
            TicketBeanFacade tf = new TicketBeanFacade();
            ShenZhenTicketPrintBean sztpb = (ShenZhenTicketPrintBean)tf.facade(StationType.SHENZHEN, ct);
            shenZhenTicketPrintBeans.add(sztpb);
        }

        apiResponse.setT(shenZhenTicketPrintBeans);

        return apiResponse;
    }

    @RequestMapping(value = "/query_ticket_by_card", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<CoachTicket>> getTicketV2(
            IdentityCard identityCard,
            @RequestParam(value = MachineRequestParameter.MACHINE_ID, required = true, defaultValue = "") String machineId){
        System.out.println("[query_ticket] id: " + identityCard.getCardId());
        System.out.println("[query_ticket] name: " + identityCard.getName());
        System.out.println("[query_ticket] nation: " + identityCard.getNation());
        System.out.println("[query_ticket] birthDate: " + identityCard.getBirthDate());
        System.out.println("[query_ticket] address: " + identityCard.getAddress());
        System.out.println("[query_ticket] sex: " + identityCard.getSex());
        //System.out.println("[query_ticket] passWord: " + identit);

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
        APIResponse<List<CoachTicket>> api = new APIResponse<>();

        api.setT(CoachTicketMocker.mockList());
        //Todo, mock data
        return new APIResponse<>();
    }


    @RequestMapping(value = "/fetch_id", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<List<CoachTicket>> fetchTicket(
        @RequestParam(value = MachineRequestParameter.MACHINE_ID,
            required = true, defaultValue = "") String machineId,
        @RequestParam(value = MachineRequestParameter.TICKET_ID,
            required = true, defaultValue = "") int ticketId) {

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
        //Todo: mock data
        APIResponse<List<CoachTicket>> ticketBeanAPIResponse = new APIResponse<>();
        ticketBeanAPIResponse.setT(CoachTicketMocker.mockList());
        return ticketBeanAPIResponse;
    }

}