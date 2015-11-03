package com.qunar.coach.machine.core;

import lombok.Data;

/**
 * Created by niuli on 15-10-30.
 */
//@Data
public class CoachTicket {
    // qunar ticketId
    protected int id;

    // 乘客姓名
    protected String passengerName;

    // 身份证号
    protected String passengerNo;

    // 票价
    protected String ticketPrice;

    // 出发时间
    protected String coachStartTime;

    // 出发城市
    protected String coachFromCity;

    // 到达城市
    protected String coachToCity;

    // 出发站
    protected String coachFrom;

    // 到达站
    protected String coachTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCoachStartTime() {
        return coachStartTime;
    }

    public void setCoachStartTime(String coachStartTime) {
        this.coachStartTime = coachStartTime;
    }

    public String getCoachFromCity() {
        return coachFromCity;
    }

    public void setCoachFromCity(String coachFromCity) {
        this.coachFromCity = coachFromCity;
    }

    public String getCoachToCity() {
        return coachToCity;
    }

    public void setCoachToCity(String coachToCity) {
        this.coachToCity = coachToCity;
    }

    public String getCoachFrom() {
        return coachFrom;
    }

    public void setCoachFrom(String coachFrom) {
        this.coachFrom = coachFrom;
    }

    public String getCoachTo() {
        return coachTo;
    }

    public void setCoachTo(String coachTo) {
        this.coachTo = coachTo;
    }
}
