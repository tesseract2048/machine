package com.wandoujia.baobab.service.common.impl;

import com.wandoujia.baobab.service.common.MachineService;
import com.wandoujia.baobab.model.MachineStatus;

import java.util.Date;

/**
 * Created by niuli on 15-10-21.
 */
public class MachineServiceImpl implements MachineService {
    public String generateMachineId(String province, String city, String stationName, Date timeStamp){
        //TODO: generate the key from 3 station info input and the timeStamp using snowflake.
        return null;
    }

    public MachineStatus getMachineStatus(String machineId){
        //TODO: query the machine status in mysql.
        return MachineStatus.LOG_OFF;
    }

}
