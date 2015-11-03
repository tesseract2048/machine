package com.qunar.coach.machine.core.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by niuli on 15-10-21.
 */
//@Data
//@Deprecated
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepCity() {
        return depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public String getArrCity() {
        return arrCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    public String getDepCitySource() {
        return depCitySource;
    }

    public void setDepCitySource(String depCitySource) {
        this.depCitySource = depCitySource;
    }

    public String getArrCitySource() {
        return arrCitySource;
    }

    public void setArrCitySource(String arrCitySource) {
        this.arrCitySource = arrCitySource;
    }

    public String getDepStation() {
        return depStation;
    }

    public void setDepStation(String depStation) {
        this.depStation = depStation;
    }

    public String getDepStationSource() {
        return depStationSource;
    }

    public void setDepStationSource(String depStationSource) {
        this.depStationSource = depStationSource;
    }

    public String getArrStation() {
        return arrStation;
    }

    public void setArrStation(String arrStation) {
        this.arrStation = arrStation;
    }

    public String getArrStationSource() {
        return arrStationSource;
    }

    public void setArrStationSource(String arrStationSource) {
        this.arrStationSource = arrStationSource;
    }

    public String getCheci() {
        return checi;
    }

    public void setCheci(String checi) {
        this.checi = checi;
    }

    public String getChexing() {
        return chexing;
    }

    public void setChexing(String chexing) {
        this.chexing = chexing;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public Integer getCoachFrom() {
        return coachFrom;
    }

    public void setCoachFrom(Integer coachFrom) {
        this.coachFrom = coachFrom;
    }

    public String getBookingUrl() {
        return bookingUrl;
    }

    public void setBookingUrl(String bookingUrl) {
        this.bookingUrl = bookingUrl;
    }

    public String getPreSellTip() {
        return preSellTip;
    }

    public void setPreSellTip(String preSellTip) {
        this.preSellTip = preSellTip;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }

    public String getMd5str() {
        return md5str;
    }

    public void setMd5str(String md5str) {
        this.md5str = md5str;
    }
}
