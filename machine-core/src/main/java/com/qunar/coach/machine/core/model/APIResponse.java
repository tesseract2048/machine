package com.qunar.coach.machine.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    public static <T> APIResponse<T> success(T data) {
        APIResponse<T> apiResponse = success();
        apiResponse.setT(data);
        return apiResponse;
    }

    public static <T> APIResponse<T> success() {
        return newAPIResponse(ResponseCode.CODE_OK);
    }

    public static <T> APIResponse<T> failed(ResponseCode responseCode) {
        return newAPIResponse(responseCode);
    }

    public static <T> APIResponse<T> failed(ResponseCode responseCode, String msg) {
        APIResponse<T> apiResponse = failed(responseCode);
        apiResponse.msg = msg;
        return apiResponse;
    }

    private static <T> APIResponse<T> newAPIResponse(ResponseCode responseCode) {
        APIResponse<T> apiResponse = new APIResponse<>();
        apiResponse.code = responseCode.getCode();
        apiResponse.msg = responseCode.getMsg();
        return apiResponse;
    }

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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
