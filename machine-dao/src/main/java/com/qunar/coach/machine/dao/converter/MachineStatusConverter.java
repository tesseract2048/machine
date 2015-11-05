package com.qunar.coach.machine.dao.converter;

import com.qunar.coach.machine.core.model.MachineStatus;
import org.jooq.impl.EnumConverter;

public class MachineStatusConverter extends EnumConverter<Byte, MachineStatus> {

    public MachineStatusConverter() {
        super(Byte.class, MachineStatus.class);
    }

    @Override
    public Byte to(MachineStatus userObject) {

        return (byte)userObject.getValue();
    }
}
