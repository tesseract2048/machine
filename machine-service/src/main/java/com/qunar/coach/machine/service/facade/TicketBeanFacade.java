package com.qunar.coach.machine.service.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.mode.StationType;
import com.qunar.coach.machine.core.mode.TicketPrintBean;
import com.qunar.coach.machine.core.mode.YunnanTicketPrintBean;
import com.qunar.coach.machine.core.model.CoachTicket;

/**
 * Created by niuli on 11/9/15.
 */
public class TicketBeanFacade {

    protected final static Logger logger = LoggerFactory
            .getLogger(TicketBeanFacade.class);

    static ImmutableMap<StationType, Class<? extends TicketPrintBean>> tpbMapping =
            ImmutableMap
                    .<StationType, Class<? extends TicketPrintBean>>builder()
                    .put(StationType.SHENZHEN, ShenZhenTicketPrintBean.class)
                    .put(StationType.YUNNAN, YunnanTicketPrintBean.class)
                    .build();

    public static TicketPrintBean facade(StationType stationType,
            CoachTicket coachTicket) {
        TicketPrintBean tpb = null;
        if (!tpbMapping.containsKey(stationType)) {
            logger.error("Not supported station type: " + stationType);
            return null;
        }
        try {
            tpb = tpbMapping.get(stationType).newInstance();
        } catch (InstantiationException e) {
            logger.error("", e);
        } catch (IllegalAccessException e) {
            logger.error("", e);
        }
        if (tpb != null) {
            tpb.acceptCoachTicket(stationType, coachTicket);
        }
        return tpb;
    }
}
