package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by niuli on 15-10-20.
 */
@Controller
@RequestMapping("/api")
public class EchoController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/v1/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getVideoBeanList(
            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return testService.returnTest() + name;
    }
}
