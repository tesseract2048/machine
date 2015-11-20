package com.qunar.coach.machine.service;

import com.qunar.coach.machine.core.model.PrintInfo;
import com.qunar.coach.machine.core.model.TicketBean;

import java.util.List;

/**
 * Created by niuli on 15-11-1.
 */
public interface TicketService {
    TicketBean getUnPrintTicketBeanById(String ticketId);

    PrintInfo startPrint(String machineId, String ticketId);

    PrintInfo notifyPrintDone(String machineId, String ticketId);

    List<TicketBean> getTicketBeanList(String cardId);

    void saveTicket(TicketBean ticketBean);

}
