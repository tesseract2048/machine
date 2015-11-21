package com.qunar.coach.machine.core.mode;

import com.qunar.coach.machine.core.model.CoachTicket;

/** */
public interface TicketPrintBean {

    void acceptCoachTicket(StationType stationType, CoachTicket coachTicket);
}
