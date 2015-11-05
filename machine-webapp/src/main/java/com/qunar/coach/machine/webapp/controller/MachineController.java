package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.MachineStatus;
import com.qunar.coach.machine.core.utils.Md5Util;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.service.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by niuli on 15-11-1.
 */
@Controller
@RequestMapping("/api/v1/machine")
@Slf4j
public class MachineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineController.class);

    private static final String NOT_REGISTER = "NULL";

    @Autowired
    private MachineService machineService;

    /**
     * Ticket machine send heart beat message in 2 condition:
     * 1. when ticket machine start up.
     * 2. every 5 minute.
     * This message should contain deviceId, and failed times, print times, suc times,
     * because the server will judge whether the paper runs off, or the print oid run off.
     * server use this message response to tell ticket machine whether need to update.
     */
    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> sendHeartBeat(Machine machine) {
        APIResponse<Machine> response = new APIResponse<>();
        String deviceId = machine.getDeviceId();
        System.out.println("[heartbeat] deviceId: " + deviceId);

        Machine retMachine = machineService.updateMachineInfoByHeartBeat(machine);
        response.setT(retMachine);

        return response;
    }

    private boolean isDeviceNotRegistered(String deviceId){
        return deviceId.equals(NOT_REGISTER);
    }

    /**
     * For machine first init. we produce a deviceId for machine,
     * using stationName, city, province and machine sequence number md5.
     * we give the deviceId to machine to save it, for the machine login use.
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> registerVideoBeanList(Machine machine) {
        System.out.println("[register] deviceId: " + machine.getDeviceId());
        String deviceId = machine.getDeviceId();
        if (!isDeviceNotRegistered(deviceId)){
            System.out.println("device has registered. id: " + deviceId);
            APIResponse<Machine> response = new APIResponse<>();
            response.setCode(APIResponse.fail);
            response.setMsg("Registered.");
            return response;
        }

        machine.setDeviceId(Md5Util.md5(machineService.produceDeviceMd5(machine)));
        machine.setLogin(MachineStatus.ONLINE);
        Machine added = machineService.addMachine(machine);
        APIResponse<Machine> response = new APIResponse<>();
        response.setT(added);
        return response;
    }
}
