package com.qunar.coach.machine.core;

import lombok.Data;

import java.util.Date;

import java.math.BigDecimal;

/**
 * Created by niuli on 15-10-20.
 */

@Data
public class TicketBean {
    // 车票号， 自增
    protected int ticketId;

    // 车票打印模式
    protected int ticketPrintMode;

    // 车票状态， 如查询成功，打印成功，查询失败，打印失败。
    protected String ticketStatus;

    // 客票类型，如全票，儿童票
    protected String ticketType;

    // 身份证号码
    protected String idCardNumber;

    // 取票号
    protected String fetchTicketId;

    // 取票密码
    protected String fetchTicketKey;

    // 出发城市
    protected String depCity;

    // 到达城市
    protected String arrCity;

    // 出发车站
    protected String depStation;

    // 到达车站
    protected String arrStation;

    // 车次号
    protected String routeNumber;

    // 出发日期
    protected Date depDate;

    // 到达日期
    protected Date arrDate;

    // 出发时间 11:00, 采用24小时制，精确到分钟
    protected String depTime;

    // 到达时间 22:11, 采用24小时制，精确到分钟
    protected String arrTime;

    // 票价
    protected BigDecimal price;

    // 座位号
    protected String seatNumber;

    // 座位类型, 如一等座位
    protected String seatType;

    // 车类型, 如普通中巴
    protected String coachType;

    // 公里数
    protected double mileage;

    // 出票机id
    protected String ticketMachineId;

    // 车次所用时间，（分钟）
    protected Integer travleTime;

    // 数据生成时间
    protected Date createTime;

    // 数据修改时间
    protected Date modifyTime;
}