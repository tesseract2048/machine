package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.MachineRequestParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by niuli on 15-10-21.
 */
@Controller
public class HeartBeatController {
    private static final Logger LOG = LoggerFactory.getLogger(HeartBeatController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/heartbeat")
    public String getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.STATION_NAME,
                    required = false, defaultValue = "") String stationName,
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = false, defaultValue = "") String machineId,
            @RequestParam(value = MachineRequestParameter.FAILED_TICKET,
                    required = false, defaultValue = "") int failed_ticket,
            @RequestParam(value = MachineRequestParameter.TOTAL_TICKET,
                    required = false, defaultValue = "") String total_ticket) {

        //TODO: check param

        //TODO: save alive status for machine into mysql.

        // update stats for the machine.

        return "SUC";
    }

}
