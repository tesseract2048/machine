package com.qunar.coach.machine.service.impl;

import static com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qunar.coach.machine.core.TicketStatus;
import com.qunar.coach.machine.core.model.*;
import com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord;
import com.qunar.coach.machine.service.JooqService;
import com.qunar.coach.machine.service.TicketService;


/**
 * Created by niuli on 15-11-1.
 */
@Service
//@Slf4j
public class TicketServiceImpl extends JooqService implements TicketService {

    @Override
    public TicketBean getUnPrintTicketBeanById(String ticketId) {
        return null;
    }

    @Override
    public PrintInfo startPrint(String machineId, String ticketId) {
        //Todo: 告诉其他服务开始打印，锁定票。不让柜台出票,其他服务返回超时时间.
        // mock数据
        PrintInfo printInfo = new PrintInfo();
        printInfo.setTicketId(ticketId);
        printInfo.setStartTime(System.currentTimeMillis());
        printInfo.setTimeOut(System.currentTimeMillis() + 10000);

        // 添加打印记录
        addPrintRecord(machineId, ticketId);

        return printInfo;
    }

    @Override
    public List<TicketBean> getTicketBeanList(String cardId) {
        return null;
    }

    @Override
    public PrintInfo notifyPrintDone(String machineId, String ticketId) {
        //Todo: 告诉其他服务，打印完成。
        change2PrintDone(machineId, ticketId);
        return new PrintInfo();
    }

    @Override
    public void saveTicket(TicketBean ticketBean){
        ;
    }

    private void change2PrintDone(String machineId, String ticketId) {
        int ret = getContext().update(TICKET_PRINT_INFO).set(TICKET_PRINT_INFO.STATUS,
                TicketStatus.FINISH).execute();
        if (ret != 1) {
            throw new APIException("Can't change to print done status");
        }
    }


    private CoachTicket getCoachTicket(int ticketId) {
        CoachTicket coachTicket = new CoachTicket();

        coachTicket.setCoachFrom("Beijing");
        coachTicket.setCoachToCity("Nanjing");

        return coachTicket;
    }

    //Todo: query from siteproxy
    private TicketSiteInfo getTicketSiteInfo() {
        TicketSiteInfo ticketSiteInfo = new TicketSiteInfo();

        ticketSiteInfo.setArrCity("Beijing");
        ticketSiteInfo.setBookingUrl("www.baidu.com");
        ticketSiteInfo.setCheci("No212");
        ticketSiteInfo.setDepCity("Nanjing");

        return ticketSiteInfo;
    }

    private void addPrintRecord(String machineId, String ticketId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        TicketPrintInfoRecord printInfo = new TicketPrintInfoRecord();

        printInfo.setCreateTime(now);
        printInfo.setModifyTime(now);
        printInfo.setPrintMachineId(machineId);
        printInfo.setTicketId(ticketId);

        int ret = getContext().insertInto(TICKET_PRINT_INFO).set(printInfo).
            onDuplicateKeyUpdate().set(TICKET_PRINT_INFO.MODIFY_TIME, now).execute();
        if (ret != 1) {
            //log.warn("Can't add print record, machineId {}, ticketId {}.", machineId, ticketId);
            throw new APIException("Can't add print record.");
        }
    }
}
