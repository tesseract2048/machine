package com.wandoujia.baobab.webapp.controller;

/**
 * Created by niuli on 15-10-21.
 */

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
public class PrintTicketController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/print_done")
    public List<TicketBean> getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = true, defaultValue = "") String machineId,
            @RequestParam(value = MachineRequestParameter.TICKET_ID,
                    required = true, defaultValue = "") String ticketId) {

        //TODO: check param
        //TODO: check machine status.
        //TODO: check ticket exist.

        /**
         * 1. callback to siteProxy.
         * 2. update ticket status in mysql.
         * 3. write back status code.
         *
         */

        return null;
    }
}