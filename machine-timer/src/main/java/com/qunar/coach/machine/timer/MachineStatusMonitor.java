package com.qunar.coach.machine.timer;

import java.sql.Timestamp;
import java.util.List;

import com.qunar.coach.machine.core.model.MachineStatus;
import com.qunar.coach.machine.core.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qunar.coach.machine.dao.model.tables.daos.MachineDao;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;

/**
 * Created by niuli on 15-11-4.
 */
public class MachineStatusMonitor {

    public static final int INTERVAL = 1000 * 60 * 1;

    // ms
    private static final int CHECK_INTERVAL = 100;

    @Autowired
    private MachineDao machineDao;

    private boolean isMachineDead(Machine machine){
        return machine.getSyncTime().
                after(new Timestamp(System.currentTimeMillis() - INTERVAL));
    }

    private void sentenceToDeath(Machine machine){
        machine.setLogin(MachineStatus.LOG_OFF);
        machineDao.update(machine);
    }

    private void checkOneMachine(Machine machine){
        if (isMachineDead(machine)) {
            System.out.print("Machine id" + machine.getId().toString() + " {} is out of date");
            sentenceToDeath(machine);
        }
    }

    private void roundCheck(){
        List<Machine> machines = machineDao.findAll();
        for (Machine machine: machines) {
            checkOneMachine(machine);
            TimeUtils.sleep(CHECK_INTERVAL);
        }
    }

    public void doTask() {
        System.out.print("monitor start. \n");
        roundCheck();
        System.out.print("monitor end. \n");
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:applicationContext-timer-base.xml");
        ((ClassPathXmlApplicationContext)ctx).registerShutdownHook();
    }
}
