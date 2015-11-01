package com.qunar.coach.machine.service.impl;

import com.qunar.coach.machine.core.MachineStatus;
import com.qunar.coach.machine.dao.model.tables.daos.MachineDao;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.dao.model.tables.records.MachineRecord;
import com.qunar.coach.machine.service.JooqService;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.service.utils.RecordMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyunfan on 15-10-25.
 */
@Service
public class MachineServiceImpl extends JooqService implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Override
    public Machine addMachine(Machine machine) {
        Machine existMachine = machineDao.fetchOneByDeviceId(machine.getDeviceId());
        if (existMachine == null) {
            machineDao.insert(machine);
        }

        return machineDao.fetchOneByDeviceId(machine.getDeviceId());
    }

    @Override
    public String generateMachineId(Machine machine) {
        return machine.getProvince() + ":" + machine.getCity() + ":" + machine.getIp();
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

    private MachineRecord toMachineRecord(Machine machine) {
        return RecordMapperUtils.mapObject(machine, MachineRecord.class);
    }
}
