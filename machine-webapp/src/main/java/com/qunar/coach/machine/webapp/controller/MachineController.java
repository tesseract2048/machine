package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.core.model.ResponseCode;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.MachineStatus;
import com.qunar.coach.machine.core.model.UpdateData;
import com.qunar.coach.machine.core.utils.Md5Util;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import com.qunar.coach.machine.service.MachineService;


/**
 * Created by niuli on 15-11-1.
 */
@Controller
@RequestMapping("/v1/machine")
@Slf4j
public class MachineController {

    private static final Logger logger = LoggerFactory.getLogger(MachineController.class);

    private static final String NOT_REGISTER = "NULL";

    private static final String UPDATE_URL = "http://l-coach.cache.f.dev.cn0.qunar.com/qunarTickets_build101_patch.zip";

    private static final String VERSION = "v1.0.2";

    // 0 means false, 1 means true.
    private static final String IS_NW_INCLUDE = "0";

    @Autowired
    private MachineService machineService;

    /**
     * Ticket machine send heart beat message in 2 condition:
     * 1. When ticket machine start up.
     * 2. Every 5 minute.
     * This message should contain deviceId, and failed times, print times, suc times,
     * because the server will judge whether the paper runs off, or the print oid runs off.
     * server uses this message response to tell ticket machine whether need to update.
     */
    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> sendHeartBeat(Machine machine) {
        try {
            //APIResponse<Machine> response = new APIResponse<>();
            String deviceId = machine.getDeviceId();
            logger.info("[heartbeat] deviceId: " + deviceId);

            Machine retMachine = machineService.updateMachineInfoByHeartBeat(machine);
            if (null == retMachine) {
                return APIResponse.failed(ResponseCode.INVALID_MACHINE);
            } else {
                APIResponse<Machine> response = APIResponse.success(retMachine);
                UpdateData updateData = new UpdateData();
                updateData.setIsNwIncluded(IS_NW_INCLUDE);
                updateData.setUpdateUrl(UPDATE_URL);
                updateData.setVersion(VERSION);
                response.setU(updateData);
                return response;
            }
        }
        catch (Exception e) {
            logger.info("[heartbeat] err " + e);
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
    }

    /**
     * For machine first init. we produce a deviceId for machine,
     * using stationName, city, province and machine sequence number md5.
     * we give the deviceId to machine to save it, for the machine login use.
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<Machine> registerMachine(Machine machine) {
        logger.info("[register] deviceId: " + machine.getDeviceId());
        String deviceId = machine.getDeviceId();
        if (!isDeviceNotRegistered(deviceId)){
            logger.info("device has registered. id: " + deviceId);
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        }

        machine.setDeviceId(Md5Util.md5(machineService.produceDeviceMd5(machine)));
        machine.setLogin(MachineStatus.ONLINE);
        Machine added = machineService.addMachine(machine);
        return APIResponse.success(added);
    }

    private boolean isDeviceNotRegistered(String deviceId){
        return deviceId.equals(NOT_REGISTER);
    }

    @RequestMapping(value = "/alarm", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse<Boolean> sendAlarm(int machineId, String message) {
        // TODO: send alarm
        System.out.println("MachineID: " + machineId + ", Message: " + message);
        return APIResponse.success(true);
    }
}
