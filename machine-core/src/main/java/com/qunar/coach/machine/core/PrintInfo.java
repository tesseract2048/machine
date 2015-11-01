package com.qunar.coach.machine.core;

import lombok.Data;

/**
 * Created by zhangyunfan on 15-11-1.
 */
@Data
public class PrintInfo {
    //开始
    private long startTime;
    // 超时时间
    private long timeOut;
    private int ticketId;
}
