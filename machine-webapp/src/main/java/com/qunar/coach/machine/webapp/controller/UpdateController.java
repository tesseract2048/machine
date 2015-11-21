package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.webapp.constant.RequestParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by niuli on 15-10-21.
 */
@Controller
public class UpdateController {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateController.class);

    @Resource
    private MachineService machineService;

    @RequestMapping("/v1/update")
    @ResponseBody
    public String getUpdateInfo(
            @RequestParam(value = RequestParameter.VERSION,
                    required = false, defaultValue = "") String version,
            @RequestParam(value = RequestParameter.MACHINE_ID,
                    required = false, defaultValue = "") String machineId) {

        //TODO: check param

        //TODO: check whether need to update.

        //TODO: adapt the update url using machineId.

        return "updateUrl";
    }

}
