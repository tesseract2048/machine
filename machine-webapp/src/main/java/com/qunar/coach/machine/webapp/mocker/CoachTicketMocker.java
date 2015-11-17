package com.qunar.coach.machine.webapp.mocker;

import com.qunar.coach.machine.core.model.CoachTicket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuli on 15-10-30.
 */
public class CoachTicketMocker {
    public static CoachTicket mock() {
        CoachTicket coachTicket = new CoachTicket();
        coachTicket.setId(1);

        coachTicket.setPassengerName("牛立");
        coachTicket.setPassengerNo("610103198809012816");
        coachTicket.setCoachFromCity("深圳");
        coachTicket.setCoachToCity("百色");

        coachTicket.setCoachFrom("龙岗站");
        coachTicket.setCoachTo("百色站");
        coachTicket.setTicketPrice("220.0");
        coachTicket.setCoachStartTime("2015-10-31 12:20");;

        //coachTicket.setId("1");
        return coachTicket;
    }

    public static CoachTicket mockAnother() {
        CoachTicket coachTicket = new CoachTicket();
        coachTicket.setId(2);

        coachTicket.setPassengerName("甘飞");
        coachTicket.setPassengerNo("101103199012212262");
        coachTicket.setCoachFromCity("深圳");
        coachTicket.setCoachToCity("南宁");

        coachTicket.setCoachFrom("宝安站");
        coachTicket.setCoachTo("百色站");
        coachTicket.setTicketPrice("390.0");
        coachTicket.setCoachStartTime("2015-12-01 12:20");;

        return coachTicket;
    }

    public static List<CoachTicket> mockList(){
        List<CoachTicket> mockList = new ArrayList<>();
        mockList.add(mock());
        mockList.add(mockAnother());
        return mockList;
    }

}

