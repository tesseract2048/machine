package com.qunar.coach.machine.timer;

import com.qunar.coach.machine.dao.model.tables.daos.MachineDao;
import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by niuli on 15-11-4.
 */

public class MachineStatusMonitor {

    public static final int INTERVAL = 1000 * 60 * 5;
    @Autowired
    private MachineDao machineDao;
    public void doTask() {
        System.out.print("hahah");
        List<Machine> machines = machineDao.findAll();
        for (Machine machine: machines) {
            if (machine.getSyncTime().
                after(new Timestamp(System.currentTimeMillis() - INTERVAL))) {
                System.out.print("Machine id" + machine.getId().toString() + " {} is out of date");
            }

        }
        System.out.print(machines);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-timer-base.xml");
        ((ClassPathXmlApplicationContext)ctx).registerShutdownHook();
    }
}
