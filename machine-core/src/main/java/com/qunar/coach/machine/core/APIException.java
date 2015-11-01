package com.qunar.coach.machine.core;

/**
 * Created by zhangyunfan on 15-11-1.
 */
public class APIException extends RuntimeException {
    private APIResponse<Void> apiResponse;

    public APIException(String msg) {
        apiResponse = new APIResponse<Void>(APIResponse.fail, msg, null);
    }

    public APIResponse<Void> getApiResponse() {
        return apiResponse;
    }
}
