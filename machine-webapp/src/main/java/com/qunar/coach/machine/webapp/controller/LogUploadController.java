package com.wandoujia.baobab.webapp.controller;

import com.wandoujia.baobab.service.webapp.LogUploadService;
import com.wandoujia.baobab.webapp.helpers.ControllerConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoli <lihao@wandoujia.com>
 */
@RestController
@RequestMapping("/api/v1")
public class LogUploadController implements ControllerConsts {

    @Autowired
    private LogUploadService logUploadService;

    @RequestMapping(value = "/log/upload", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String count(
            @RequestParam(value = "data", required = true, defaultValue = "") String data,
            @RequestParam(value = "type", required = true, defaultValue = "") String type) {

        boolean success = logUploadService.insert(type, data);

        return success ? SUCCESS : FAILED;
    }
}
