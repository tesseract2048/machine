package com.qunar.coach.machine.service;

import com.qunar.coach.machine.core.PrintInfo;
import com.qunar.coach.machine.core.TicketBean;

import java.util.List;

/**
 * Created by zhangyunfan on 15-11-1.
 */
public interface TicketService {
    TicketBean getUnPrintTicketBeanById(int ticketId);

    PrintInfo startPrint(String machineId, int ticketId);

    PrintInfo notifyPrintDone(String machineId, int ticketId);

    List<TicketBean> getTicketBeanList(String cardId);
}
