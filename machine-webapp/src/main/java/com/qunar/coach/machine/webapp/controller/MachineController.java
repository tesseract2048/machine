package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.core.APIResponse;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.service.MachineService;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    private MachineService machineService;

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> sendHeartBeat(Machine machine) {

        //Todo: mock data
        return new APIResponse<>();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> registerVideoBeanList(Machine machine) {
        log.info("Machine device id {} register", machine.getDeviceId());
        Machine added = machineService.addMachine(machine);
        APIResponse<Machine> response = new APIResponse<>();

        response.setT(added);
        return response;
    }
}
