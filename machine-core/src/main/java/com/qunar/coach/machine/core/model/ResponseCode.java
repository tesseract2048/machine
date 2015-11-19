package com.qunar.coach.machine.core.model;

/**
 * Created by niuli on 11/16/15.
 */
public enum  ResponseCode {

    CODE_OK(0, "OK"),
    NO_TICKET(1, ""),
    INVALID_MACHINE(2, "Device id not exist."),
    REQUEST_PARAM_ERROR(3, "Request param error"),
    SYSTEM_ERROR(4, "System error"),
    ;

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

