package com.qunar.coach.machine.core.mode;

/**
 * Created by niuli on 11/9/15.
 */

// we use the ticket mode in SHEN ZHEN station.
public class ShenZhenTicketPrintBean {
    // 线路 A13838
    private String line;

    // 乘车站
    private String take_place;

    // 到车站
    private String destination;

    // 发车时间
    private String start_time;

    // 车型
    private String type;

    // 座号
    private String seat_number;

    // 票价
    private String price;

    // 检票口
    private String check_port_number;

    // 售票点
    private String sell_ticket_place;

    // 班次
    private String number;

    //票号
    private String ticket_number;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTake_place() {
        return take_place;
    }

    public void setTake_place(String take_place) {
        this.take_place = take_place;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCheck_port_number() {
        return check_port_number;
    }

    public void setCheck_port_number(String check_port_number) {
        this.check_port_number = check_port_number;
    }

    public String getSell_ticket_place() {
        return sell_ticket_place;
    }

    public void setSell_ticket_place(String sell_ticket_place) {
        this.sell_ticket_place = sell_ticket_place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
    }

}
