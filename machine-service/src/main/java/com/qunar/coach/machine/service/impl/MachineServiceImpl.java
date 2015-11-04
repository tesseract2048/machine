package com.qunar.coach.machine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qunar.coach.machine.core.model.APIException;
import com.qunar.coach.machine.dao.model.tables.daos.MachineDao;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.dao.model.tables.records.MachineRecord;
import com.qunar.coach.machine.service.JooqService;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.service.utils.RecordMapperUtils;

import java.sql.Timestamp;

/**
 * Created by niuli on 15-10-25.
 */
@Service
public class MachineServiceImpl extends JooqService implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Override
    public Machine addMachine(Machine machine) {
        Machine existMachine = machineDao.fetchOneByDeviceId(machine.getDeviceId());
        if (existMachine == null) {
            machine.setLogin(APIException.MachineStatus.ONLINE);
            machineDao.insert(machine);
        } else {
            return existMachine;
        }

        return machineDao.fetchOneByDeviceId(machine.getDeviceId());
    }

    @Override
    public void updateMachineInfo(Machine machine){
        machineDao.update(machine);
    }

    @Override
    public Machine updateMachineInfoByHeartBeat(Machine machine){
        Machine existMachine = machineDao.fetchOneByDeviceId(machine.getDeviceId());
        if (existMachine == null) {
            return null;
        }
        else {
            long start = System.currentTimeMillis();
            Timestamp ts = new Timestamp(start);
            machine.setSyncTime(ts);
            existMachine.setLogin(APIException.MachineStatus.ONLINE);
            existMachine.setSyncTime(ts);
            existMachine.setPaperNumber(machine.getPaperNumber());
            existMachine.setPaperUsed(machine.getPaperUsed());
            existMachine.setSucTimes(machine.getSucTimes());
            existMachine.setFailedTimes(machine.getFailedTimes());
            machineDao.update(existMachine);
            return existMachine;
        }

    }

    @Override
    public Machine getMachine(int machineId) {
        return machineDao.fetchOneById(machineId);
    }

    @Override
    public Machine getMachine(String deviceId) {
        return machineDao.fetchOneByDeviceId(deviceId);
    }

    @Override
    public String generateMachineId(Machine machine) {
        return machine.getProvince() + ":" + machine.getCity() + ":" + machine.getIp();
    }

    @Override
    public APIException.MachineStatus getMachineStatus(String machineId) {
        return null;
    }

    @Override
    public boolean setMachineStatus(String machineId, APIException.MachineStatus machineStatus) {
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
