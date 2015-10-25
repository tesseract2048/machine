package com.qunar.coach.machine.service.impl;

import com.qunar.coach.machine.core.MachineStatus;
import com.qunar.coach.machine.service.MachineService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhangyunfan on 15-10-25.
 */
@Service
public class MachineServiceImpl implements MachineService {
    @Override
    public String generateMachineId(String province, String city, String stationName, Date timeStamp) {
        return province + ":" + city + ":" + stationName;
    }

    @Override
    public MachineStatus getMachineStatus(String machineId) {
        return null;
    }

    @Override
    public boolean setMachineStatus(String machineId, MachineStatus machineStatus) {
        return false;
    }

    @Override
    public boolean scanDeadMachine() {
        return false;
    }
}
