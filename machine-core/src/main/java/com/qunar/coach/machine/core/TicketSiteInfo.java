package com.qunar.coach.machine.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by niuli on 15-10-21.
 */
public class TicketSiteInfo implements Serializable {
    private static final long serialVersionUID = -1244770353544973701L;

    /**
     * 出发城市
     */
    private String depCity;

    /**
     * 到达城市
     */
    private String arrCity;

    /**
     * 原始出发城市，与代理商内部一致
     */
    private String depCitySource;

    private String arrCitySource;

    /**
     * /** 出发车站
     */
    private String depStation;

    /**
     * 原始出发车站，与代理商内部一致
     */
    private String depStationSource;

    /**
     * 到达车站
     */
    private String arrStation;

    /**
     * 原始到达车站，与代理商内部一致
     */
    private String arrStationSource;

    /**
     * 车次
     */
    private String checi;

    /**
     * 车型
     */
    private String chexing;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 出发日期
     */
    private Date ticketDate;
    /**
     * 出发时间
     */
    private String depTime;

    /**
     * 到达时间
     */
    private String arrTime;

    /**
     * 里程
     */
    private Integer mileage;

    /**
     * 运行时间
     */
    private Integer periodTime;

    /**
     * 数据来源（从哪个网站抓取的）
     */
    private Integer coachFrom;

    private String bookingUrl;

    private String preSellTip;

    private Integer minLimit;// 最少距离开车前多少分钟可以购票(+缓冲)

    private String md5str;


}
