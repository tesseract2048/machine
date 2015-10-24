package com.wandoujia.baobab.webapp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wandoujia.baobab.constant.MachineRequestParameter;
import com.wandoujia.baobab.service.common.MachineService;

/**
 * Created by niuli on 15-10-21.
 */
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/login")
    public String getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.STATION_NAME,
                    required = false, defaultValue = "") String stationName,
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = false, defaultValue = "") String machineId) {

        //TODO: check param
        //TODO: save status for machine into mysql.

        return "SUC";
    }

}
