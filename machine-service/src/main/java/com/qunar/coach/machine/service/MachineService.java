package com.qunar.coach.machine.service;

import com.qunar.coach.machine.core.model.APIException;
import com.qunar.coach.machine.core.model.MachineStatus;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;


/**
 * Created by niuli on 15-10-21.
 */
public interface MachineService {

    Machine addMachine(Machine machine);

    String generateMachineId(Machine machine);

    Machine getMachine(int machineId);

    Machine getMachine(String deviceId);

    /**
     * get machine status
     *
     * @param machineId String
     * @return MachineStatus
     */
    MachineStatus getMachineStatus(String machineId);

    /**
     * to set machine status
     *
     * @param machineId String
     * @return boolean
     */
    boolean setMachineStatus(String machineId, MachineStatus machineStatus);

    /**
     * update machine status
     * 1. check machine list in mysql to find the machine which has not sent heart beat request message.
     * 2. update the machine status to logout.
     *
     * @return boolean
     */
    boolean scanDeadMachine();

    /**
     * update machine status
     *
     * @return void
     */
    void updateMachineInfo(Machine machine);

    /**
     * update machine info.
     * 1. update the machine sync time and Login status.
     *
     * @return Machine
     */
    Machine updateMachineInfoByHeartBeat(Machine machine);

    String produceDeviceMd5(Machine machine);

}
