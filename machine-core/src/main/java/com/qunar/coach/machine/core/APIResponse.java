package com.qunar.coach.machine.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyunfan on 15-11-1.
 */
@Data
@AllArgsConstructor
public class APIResponse<T> {
    private int code;
    private String msg;
    private T t;

    public APIResponse() {
        this.code = APIResponse.suc;
    }

    public static final int suc = 0;
    public static final int fail = -1;
}
