package com.qunar.coach.machine.webapp.controller;

/**
 * Created by niuli on 15-10-21.
 */

import javax.annotation.Resource;

import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.PrintInfo;
import com.qunar.coach.machine.dao.model.tables.pojos.IdentityCard;
import com.qunar.coach.machine.service.PersonIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qunar.coach.machine.core.model.TicketBean;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.MachineRequestParameter;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/printStart", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<PrintInfo> printStart(
        @RequestParam(value = MachineRequestParameter.MACHINE_ID,
            required = true, defaultValue = "") String machineId,
        @RequestParam(value = MachineRequestParameter.TICKET_ID,
            required = true, defaultValue = "") String ticketId) {
        //Todo: Mock Data
        return null;
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
        return null;
    }

    @RequestMapping(value = "/query_ticket", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<TicketBean> getVideoBeanList(
        IdentityCard identityCard,
        @RequestParam(value = MachineRequestParameter.MACHINE_ID, required = true, defaultValue = "") String machineId) {

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
        return new APIResponse<>();
    }


    @RequestMapping(value = "/fetch_id", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<TicketBean> fetchTicket(
        @RequestParam(value = MachineRequestParameter.MACHINE_ID,
            required = true, defaultValue = "") String machineId,
        @RequestParam(value = MachineRequestParameter.TICKET_ID,
            required = true, defaultValue = "") String fetchTicketId) {

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
        return new APIResponse<>();
    }
}