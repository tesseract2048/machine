package com.wandoujia.baobab.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wandoujia.baobab.bean.TicketBean;
import com.wandoujia.baobab.constant.MachineRequestParameter;
import com.wandoujia.baobab.service.common.MachineService;

/**
 * Created by niuli on 15-10-21.
 */
public class QueryTicketController {
    private static final Logger LOG = LoggerFactory.getLogger(QueryTicketController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/query_ticket")
    public List<TicketBean> getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = true, defaultValue = "") String machineId,
            @RequestParam(value = MachineRequestParameter.CARD_ID,
                    required = true, defaultValue = "") String cardId,
            @RequestParam(value = MachineRequestParameter.CARD_NAME,
                    required = false, defaultValue = "") String cardName,
            @RequestParam(value = MachineRequestParameter.CARD_SEX,
                    required = false, defaultValue = "") String cardSex,
            @RequestParam(value = MachineRequestParameter.CARD_NATION,
                    required = false, defaultValue = "") String cardNation,
            @RequestParam(value = MachineRequestParameter.CARD_BIRTH_DATE,
                    required = false, defaultValue = "") String cardBirthDate,
            @RequestParam(value = MachineRequestParameter.CARD_ADDRESS,
                    required = false, defaultValue = "") String cardAddress,
            @RequestParam(value = MachineRequestParameter.STATION_NAME,
                    required = false, defaultValue = "") String stationName) {

        //TODO: check param
        //TODO: check machine status

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

        return null;
    }
}