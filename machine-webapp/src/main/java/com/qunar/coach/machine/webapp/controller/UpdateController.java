package com.qunar.coach.machine.webapp.controller;

import javax.annotation.Resource;

import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.MachineRequestParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by niuli on 15-10-21.
 */
public class UpdateController {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/update")
    public String getVideoBeanList(
            @RequestParam(value = MachineRequestParameter.VERSION,
                    required = false, defaultValue = "") String version,
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = false, defaultValue = "") String machineId) {

        //TODO: check param

        //TODO: check whether need to update.

        //TODO: adapt the update url using machineId.

        return "updateUrl";
    }

}
