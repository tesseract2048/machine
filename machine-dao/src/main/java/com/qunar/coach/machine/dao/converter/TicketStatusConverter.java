package com.qunar.coach.machine.dao.converter;

import com.qunar.coach.machine.core.TicketStatus;
import org.jooq.impl.EnumConverter;

public class TicketStatusConverter extends EnumConverter<String, TicketStatus> {

    public TicketStatusConverter() {
        super(String.class, TicketStatus.class);
    }

    @Override
    public String to(TicketStatus userObject) {
        return userObject.name();
    }
}
