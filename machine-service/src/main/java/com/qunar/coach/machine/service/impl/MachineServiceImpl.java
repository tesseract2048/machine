package com.qunar.coach.machine.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qunar.coach.machine.core.model.MachineStatus;
import com.qunar.coach.machine.core.utils.DeviceIdProducer;
import com.qunar.coach.machine.dao.model.tables.daos.MachineDao;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.dao.model.tables.records.MachineRecord;
import com.qunar.coach.machine.service.JooqService;
import com.qunar.coach.machine.service.MachineService;
import com.qunar.coach.machine.service.utils.RecordMapperUtils;

/**
 * Created by niuli on 15-10-25.
 */
@Service
public class MachineServiceImpl extends JooqService implements MachineService {

    @Autowired
    private MachineDao machineDao;

    private static int MACHINE_PAPER_NUMBER = 6000;

    @Override
    public Machine addMachine(Machine machine) {
        Machine existMachine = machineDao.fetchOneByDeviceId(machine.getDeviceId());
        if (existMachine == null) {
            machine.setLogin(MachineStatus.ONLINE);
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

    private Machine setMachineAlive(Machine machine){
        long start = System.currentTimeMillis();
        Timestamp ts = new Timestamp(start);
        machine.setSyncTime(ts);
        machine.setLogin(MachineStatus.ONLINE);
        machine.setSyncTime(ts);
        return machine;
    }

    private Machine updateMachineNumber(Machine existMachine, Machine inputMachine){
        int totalPaperUsed = inputMachine.getPaperUsed() + existMachine.getPaperUsed();
        existMachine.setPaperUsed(totalPaperUsed);
        existMachine.setPaperNumber(MACHINE_PAPER_NUMBER - totalPaperUsed);
        existMachine.setSucTimes(existMachine.getSucTimes() + inputMachine.getSucTimes());
        existMachine.setFailedTimes(existMachine.getFailedTimes() + inputMachine.getFailedTimes());
        return existMachine;
    }

    @Override
    public Machine updateMachineInfoByHeartBeat(Machine machine){
        Machine existMachine = machineDao.fetchOneByDeviceId(machine.getDeviceId());
        if (existMachine == null) {
            return null;
        }
        else {
            setMachineAlive(existMachine);
            //updateMachineNumber(existMachine, machine);
            existMachine.setMaintenance(0);
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

    public String produceDeviceMd5(Machine machine){
        String province = machine.getProvince();
        String city = machine.getCity();
        int sequenceNumber = machine.getSequenceNumber();
        String stationInfo = machine.getStationInfo();
        return DeviceIdProducer.produceDeviceId(stationInfo, city, province, sequenceNumber);
    }

    @Override
    public boolean isDeviceExist(String deviceId){
        if (machineDao.fetchByDeviceId(deviceId) == null){
            return false;
        }

        return true;
    }
}
