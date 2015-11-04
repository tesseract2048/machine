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
public class AdminController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/api/v1/admin/update")
    public String admin(
            @RequestParam(value = MachineRequestParameter.VERSION,
                    required = false, defaultValue = "") String version,
            @RequestParam(value = MachineRequestParameter.MACHINE_ID,
                    required = false, defaultValue = "") String machineId) {

        //TODO: check param

        //TODO: update mysql where version management.

        return "result";
    }

}
