package com.wandoujia.baobab.service.common;

import java.util.Date;

import com.wandoujia.baobab.model.MachineStatus;

/**
 * Created by niuli on 15-10-21.
 */
public interface MachineService {

    /**
     * to gererate machineId
     * @param province String
     * @param city String
     * @param stationName String
     * @param timeStamp Date
     * @return String
     */
    String generateMachineId(String province, String city, String stationName, Date timeStamp);

    /**
     * get machine status
     * @param machineId String
     * @return MachineStatus
     */
    MachineStatus getMachineStatus(String machineId);

    /**
     * to set machine status
     * @param machineId String
     * @return boolean
     */
    boolean setMachineStatus(String machineId, MachineStatus machineStatus);

    /**
     * update machine status
     * 1. check machine list in mysql to find the machine which has not sent heart beat request message.
     * 2. update the machine status to logout.
     * @return boolean
     */
    boolean scanDeadMachine();

}
