package com.qunar.coach.machine.service.facade;

import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.mode.StationType;
import com.qunar.coach.machine.core.mode.YunnanTicketPrintBean;
import com.qunar.coach.machine.core.model.CoachTicket;

/**
 * Created by niuli on 11/9/15.
 */
public class TicketBeanFacade {

    public static Object facade(StationType stationType, CoachTicket coachTicket){
        if (stationType.equals(StationType.SHENZHEN)){
            ShenZhenTicketPrintBean ticketPrintBean = new ShenZhenTicketPrintBean();
            ticketPrintBean.setDestination(coachTicket.getCoachTo());
            ticketPrintBean.setLine(coachTicket.getCoachFrom() + "->" + coachTicket.getCoachTo());
            ticketPrintBean.setPrice(coachTicket.getTicketPrice());
            ticketPrintBean.setCheck_port_number("12");
            ticketPrintBean.setDestination("百色");
            ticketPrintBean.setSell_ticket_place("宝安售票口");
            ticketPrintBean.setTake_place("深圳");
            ticketPrintBean.setType("普通");
            ticketPrintBean.setStart_time("16:35");
            ticketPrintBean.setPassengerName("杨幂");
            ticketPrintBean.setTicketId("1234234223");
            ticketPrintBean.setTicket_number("BA-1234");
            ticketPrintBean.setNumber("Rout-4440");
            ticketPrintBean.setSeat_number("19");

            return ticketPrintBean;
        }
        else if (stationType.equals(StationType.YUNNAN)){
            YunnanTicketPrintBean yunnanTicketPrintBean = new YunnanTicketPrintBean();
            yunnanTicketPrintBean.setRoute(coachTicket.getCoachFrom() + "->" + coachTicket.getCoachTo());
            yunnanTicketPrintBean.setDate(coachTicket.getCoachStartTime());
            yunnanTicketPrintBean.setExecutePrice(coachTicket.getTicketPrice());

            return yunnanTicketPrintBean;
        }

        return null;
    }
}
