package com.wandoujia.baobab.service.common;

import com.wandoujia.baobab.bean.TicketBean;

/**
 * Created by niuli on 15-10-21.
 */
public interface TicketService {

    /**
     * to write ticket info
     * @param ticketBean TicketBean
     * @return void
     */
    void writeTicketInfo(TicketBean ticketBean);

    /**
     * get ticket bean
     * @param ticketId String
     */
    TicketBean getTicketInfo(String ticketId);


}
