package com.qunar.coach.machine.webapp.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qunar.coach.machine.core.model.APIException;
import com.qunar.coach.machine.core.model.APIResponse;

/**
 * Created by niuli on 15-10-30.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingControllerAdvice {
    @ExceptionHandler(APIException.class)
    @ResponseBody
    public APIResponse<String> handleException(APIException exception) {
        //log.warn("APIException {}", exception.getApiResponse().getMsg());
        return exception.getApiResponse();
    }
}
