package com.qunar.coach.machine.service.facade;

import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.mode.StationType;
import com.qunar.coach.machine.core.mode.YunnanTicketPrintBean;
import com.qunar.coach.machine.core.model.CoachTicket;

/**
 * Created by niuli on 11/9/15.
 */
public class TicketBeanFacade {

    public Object facade(StationType stationType, CoachTicket coachTicket){
        if (stationType.equals(StationType.SHENZHEN)){
            ShenZhenTicketPrintBean ticketPrintBean = new ShenZhenTicketPrintBean();
            ticketPrintBean.setDestination(coachTicket.getCoachTo());
            ticketPrintBean.setLine(coachTicket.getCoachFrom() + "->" + coachTicket.getCoachTo());
            ticketPrintBean.setPrice(coachTicket.getTicketPrice());
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
