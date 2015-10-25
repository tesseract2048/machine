package com.qunar.coach.machine.webapp.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.MachineRequestParameter;

/**
 * Created by niuli on 15-10-21.
 */
@Controller
public class RegisterController {
    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/register")
    public String registerVideoBeanList(
            @RequestParam(value = MachineRequestParameter.PROVINCE,
                    required = false, defaultValue = "") String province,
            @RequestParam(value = MachineRequestParameter.CITY,
                    required = false, defaultValue = "") String city,
            @RequestParam(value = MachineRequestParameter.STATION_NAME,
                    required = false, defaultValue = "") String stationName) {

        //TODO: check param
        Date timeStamp = new Date();
        String newMachineId =  machineService.generateMachineId(province, city, stationName, timeStamp);

        //TODO: save newMachineId into mysql.
        return newMachineId;
    }


}
