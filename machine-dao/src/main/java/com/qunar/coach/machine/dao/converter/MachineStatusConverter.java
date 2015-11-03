package com.qunar.coach.machine.dao.converter;

import com.qunar.coach.machine.core.model.APIException;
import org.jooq.impl.EnumConverter;

public class MachineStatusConverter extends EnumConverter<Byte, APIException.MachineStatus> {

    public MachineStatusConverter() {
        super(Byte.class, APIException.MachineStatus.class);
    }

    @Override
    public Byte to(APIException.MachineStatus userObject) {
        return null;
    }
}
