package com.qunar.coach.machine.core;

import lombok.Data;

import java.util.Date;

import java.math.BigDecimal;

/**
 * Created by niuli on 15-10-20.
 */

//@Data
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

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketPrintMode() {
        return ticketPrintMode;
    }

    public void setTicketPrintMode(int ticketPrintMode) {
        this.ticketPrintMode = ticketPrintMode;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getFetchTicketId() {
        return fetchTicketId;
    }

    public void setFetchTicketId(String fetchTicketId) {
        this.fetchTicketId = fetchTicketId;
    }

    public String getFetchTicketKey() {
        return fetchTicketKey;
    }

    public void setFetchTicketKey(String fetchTicketKey) {
        this.fetchTicketKey = fetchTicketKey;
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

    public String getDepStation() {
        return depStation;
    }

    public void setDepStation(String depStation) {
        this.depStation = depStation;
    }

    public String getArrStation() {
        return arrStation;
    }

    public void setArrStation(String arrStation) {
        this.arrStation = arrStation;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getTicketMachineId() {
        return ticketMachineId;
    }

    public void setTicketMachineId(String ticketMachineId) {
        this.ticketMachineId = ticketMachineId;
    }

    public Integer getTravleTime() {
        return travleTime;
    }

    public void setTravleTime(Integer travleTime) {
        this.travleTime = travleTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}