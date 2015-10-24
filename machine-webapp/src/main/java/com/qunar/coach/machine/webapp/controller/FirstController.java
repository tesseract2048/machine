package com.qunar.coach.machine.webapp.controller;

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
public class FirstController {

    @RequestMapping(value = "/v1/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getVideoBeanList(
            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return "Hello " + name;
    }
}
