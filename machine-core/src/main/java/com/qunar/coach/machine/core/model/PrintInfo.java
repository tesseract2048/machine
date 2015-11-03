package com.qunar.coach.machine.core.model;

import lombok.Data;

/**
 * Created by niuli on 15-11-1.
 */
//@Data
public class PrintInfo {
    //开始
    private long startTime;
    // 超时时间
    private long timeOut;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    private int ticketId;
}
