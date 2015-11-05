package com.qunar.coach.machine.core.model;

/**
 * Created by niuli on 15-11-1.
 */
public class APIException extends RuntimeException {
    private APIResponse<String> apiResponse;

    public APIException(String msg) {
        apiResponse = new APIResponse<String>(APIResponse.fail, msg, null);
    }

    public APIResponse<String> getApiResponse() {
        return apiResponse;
    }
}
