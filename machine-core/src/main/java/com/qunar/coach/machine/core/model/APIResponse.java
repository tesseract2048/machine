package com.qunar.coach.machine.core.model;

import java.util.Map;

/**
 * Created by niuli on 15-11-1.
 */
//@Data
public class APIResponse<T> {
    private int code;
    private String msg;
    private T t;
    private Object u;

    public APIResponse() {
        this.code = APIResponse.suc;
    }

    public APIResponse(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public static final int suc = 0;
    public static final int fail = -1;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public Object getU() {
        return u;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setU(Object u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", t=" + t +
                ", u=" + u +
                '}';
    }
}
