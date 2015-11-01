package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.core.APIException;
import com.qunar.coach.machine.core.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangyunfan on 15-3-30.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingControllerAdvice {
    @ExceptionHandler(APIException.class)
    @ResponseBody
    public APIResponse<Void> handleException(APIException exception) {
        log.warn("APIException {}", exception.getApiResponse().getMsg());
        return exception.getApiResponse();
    }
}
