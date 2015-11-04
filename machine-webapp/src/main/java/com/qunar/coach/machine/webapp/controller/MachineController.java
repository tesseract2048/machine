package com.qunar.coach.machine.webapp.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.utils.Md5Util;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.service.MachineService;


/**
 * Created by niuli on 15-11-1.
 */
@Controller
@RequestMapping("/api/v1/machine")
@Slf4j
public class MachineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineController.class);

    @Autowired
    private MachineService machineService;

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> sendHeartBeat(
        @RequestParam(value = "deviceId") String deviceId) {
        APIResponse<Machine> response = new APIResponse<>();

        response.setT(machineService.getMachine(deviceId));
        //Todo: mock data
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> registerVideoBeanList(Machine machine) {
        System.out.println("result: " + machine.getDeviceId());
        String station = machine.getStationInfo();
        System.out.println(" md5: " + Md5Util.md5(station));

        machine.setDeviceId(Md5Util.md5(station));
        Machine added = machineService.addMachine(machine);
        APIResponse<Machine> response = new APIResponse<>();

        response.setT(added);
        return response;
    }
}
