package com.qunar.coach.machine.core;

import lombok.Data;

/**
 * Created by niuli on 15-10-30.
 */
@Data
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
}
