package com.qunar.coach.machine.core.mode;

/**
 * Created by niuli on 11/9/15.
 */
public class YunnanTicketPrintBean {
    // 发票号码
    private String number;

    // 发车日期
    private String date;

    // 执行票价
    private String executePrice;

    // 发车时间
    private String startTime;

    // 做诶号
    private String seatNumber;

    // 车辆车型/等级/类别， 如普通中巴
    private String level;

    // 上限票价
    private String upperLimitPrice;

    // 乘车地点
    private String takeTrainPlace;

    // 检票口
    private String checkPortNumber;

    private String ticketType;

    private String printTicketDate;

    private String receiptNumber;

    //路线 丽水客运站 -> 大理
    private String route;

    // 取票机器
    private String pickTicketPlace;

    // 是否带小孩, 这个写为固定的 此票不含免票儿童
    private String takeChild;

    // 客票类型
    private String category;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExecutePrice() {
        return executePrice;
    }

    public void setExecutePrice(String executePrice) {
        this.executePrice = executePrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(String upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public String getTakeTrainPlace() {
        return takeTrainPlace;
    }

    public void setTakeTrainPlace(String takeTrainPlace) {
        this.takeTrainPlace = takeTrainPlace;
    }

    public String getCheckPortNumber() {
        return checkPortNumber;
    }

    public void setCheckPortNumber(String checkPortNumber) {
        this.checkPortNumber = checkPortNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getPrintTicketDate() {
        return printTicketDate;
    }

    public void setPrintTicketDate(String printTicketDate) {
        this.printTicketDate = printTicketDate;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPickTicketPlace() {
        return pickTicketPlace;
    }

    public void setPickTicketPlace(String pickTicketPlace) {
        this.pickTicketPlace = pickTicketPlace;
    }

    public String getTakeChild() {
        return takeChild;
    }

    public void setTakeChild(String takeChild) {
        this.takeChild = takeChild;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
