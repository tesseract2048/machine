package com.qunar.coach.machine.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by niuli on 15-10-20.
 */
@Controller
@RequestMapping("/api")
public class FirstController {

    @RequestMapping("/v1/hello")
    public String getVideoBeanList(
            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return "Hello " + name;
    }
}
