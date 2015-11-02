package com.qunar.coach.machine.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by niuli on 15-11-1.
 */
@Data
public class APIResponse<T> {
    private int code;
    private String msg;
    private T t;

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
}
