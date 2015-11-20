package com.qunar.coach.machine.adapter.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.szlw.station.dto.SearchElecTicketInfoDto;
import com.szlw.station.dto.param.AutoReticketSelInfoParam;
import com.szlw.station.dto.param.AutoSellResticketInfoParam;
import com.szlw.station.dto.ret.ReturnMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * @author weixin.gong
 * @date 15-11-20 下午2:51
 */
@Service
public class ShenZhenService {
    //private final StationAgent stationAgent = StationAgentFactory.getStationAgent();
    private final Map<String, SearchElecTicketInfoDto> cache = Maps.newConcurrentMap();

    public boolean validatorSearchTicketsParam(String idCard, String password, String orderNo) {
        return validatorIdCardAndPassword(idCard, password) || validatorOrderNoAndPassword(orderNo, password);
    }

    private boolean validatorIdCardAndPassword(String idCard, String password) {
        return validatorIdCard(idCard);
    }

    private boolean validatorOrderNoAndPassword(String orderNo, String password) {
        return validatorOrderNo(orderNo);
    }

    private boolean validatorIdCard(String idCard) {
        return StringUtils.isNotBlank(idCard);
    }

    private boolean validatorOrderNo(String orderNo) {
        return StringUtils.isNotBlank(orderNo);
    }

    public List<ShenZhenTicketPrintBean> searchTickets(String idCard, String password, String orderNo)
            throws RemoteException {
        AutoReticketSelInfoParam param = newAutoReticketSelInfoParam(idCard, password, orderNo);
        @SuppressWarnings("unchecked")
        //List<SearchElecTicketInfoDto> ticketInfoList = stationAgent.searchElecTicket(param);
        List<SearchElecTicketInfoDto> ticketInfoList = mock();
        setCache(ticketInfoList);
        return toBeanList(ticketInfoList, idCard);
    }

    private AutoReticketSelInfoParam newAutoReticketSelInfoParam(String idCard, String password, String orderNo) {
        AutoReticketSelInfoParam param = new AutoReticketSelInfoParam();
        param.setIcardCode(idCard);
        param.setPwd(password);
        param.setBillNo(orderNo);
        return param;
    }

    private List<SearchElecTicketInfoDto> mock() {
        List<SearchElecTicketInfoDto> list = Lists.newArrayList();
        SearchElecTicketInfoDto ticketInfoDto = new SearchElecTicketInfoDto();
        ticketInfoDto.setCheckEntry("检票口5");
        ticketInfoDto.setReachStation("深圳");
        ticketInfoDto.setStartStation("广州");
        ticketInfoDto.setScheduleCode("1001");
        ticketInfoDto.setPassengerName("小明");
        ticketInfoDto.setTicketPrice(21.5);
        ticketInfoDto.setSeatNo(1);
        ticketInfoDto.setSaleStation("广州总站");
        ticketInfoDto.setRideDate("2015-10-10");
        ticketInfoDto.setRideTime("10:10");
        ticketInfoDto.setPtrResticketMasterId(2);
        ticketInfoDto.setSequenceNo("001");
        ticketInfoDto.setBusType("普通");
        list.add(ticketInfoDto);
        return list;
    }

    private void setCache(List<SearchElecTicketInfoDto> ticketInfoList) {
        cache.clear();
        for (SearchElecTicketInfoDto ticketInfoDto : ticketInfoList) {
            cache.put(String.valueOf(ticketInfoDto.getPtrResticketMasterId()), ticketInfoDto);
        }
    }

    private List<ShenZhenTicketPrintBean> toBeanList(List<SearchElecTicketInfoDto> ticketInfoList, String idCard) {
        List<ShenZhenTicketPrintBean> list = Lists.newArrayList();
        for (SearchElecTicketInfoDto ticketInfoDto : ticketInfoList) {
            list.add(toBean(ticketInfoDto, idCard));
        }
        return list;
    }

    private ShenZhenTicketPrintBean toBean(SearchElecTicketInfoDto ticketInfoDto, String idCard) {
        ShenZhenTicketPrintBean bean = new ShenZhenTicketPrintBean();
        bean.setIdCard(idCard);
        bean.setCheck_port_number(ticketInfoDto.getCheckEntry());
        bean.setDestination(ticketInfoDto.getReachStation());
        bean.setLine(StringUtils.join(ticketInfoDto.getStartStation(), " - ", ticketInfoDto.getReachStation()));
        bean.setNumber(ticketInfoDto.getScheduleCode());
        bean.setPassengerName(ticketInfoDto.getPassengerName());
        bean.setPrice(String.valueOf(ticketInfoDto.getTicketPrice()));
        bean.setSeat_number(String.valueOf(ticketInfoDto.getSeatNo()));
        bean.setSell_ticket_place(ticketInfoDto.getSaleStation());
        bean.setStart_time(StringUtils.join(ticketInfoDto.getRideDate(), " ", ticketInfoDto.getRideTime()));
        bean.setTake_place(ticketInfoDto.getStartStation());
        bean.setTicket_number(String.valueOf(ticketInfoDto.getPtrResticketMasterId()));
        bean.setTicketId(String.valueOf(ticketInfoDto.getPtrResticketMasterId()));
        bean.setType(ticketInfoDto.getBusType());
        return bean;
    }

    public boolean validatorTicketId(String ticketId) {
        return StringUtils.isNotBlank(ticketId) && cache.containsKey(ticketId);
    }

    public ReturnMsg printedTicket(String ticketId) throws RemoteException {
        Preconditions.checkArgument(cache.containsKey(ticketId));
        AutoSellResticketInfoParam param = newAutoSellResticketInfoParam(cache.get(ticketId));
        cache.clear();
        //return stationAgent.autoSellResticket(param);
        return null;
    }

    private AutoSellResticketInfoParam newAutoSellResticketInfoParam(SearchElecTicketInfoDto ticketInfoDto) {
        AutoSellResticketInfoParam param = new AutoSellResticketInfoParam();
        param.setResticketIdStr(String.valueOf(ticketInfoDto.getPtrResticketMasterId()));
        param.setRideDate(ticketInfoDto.getRideDate());
        param.setScheduleId(String.valueOf(ticketInfoDto.getPtrScheduleId()));
        param.setBusTypeId(String.valueOf(ticketInfoDto.getPtrBusTypeId()));
        param.setFromStationId(String.valueOf(ticketInfoDto.getStartStationId()));
        param.setToStationId(String.valueOf(ticketInfoDto.getReachStationId()));
        param.setIsCommon(ticketInfoDto.getIsCommon());
        param.setSeller("");
        param.setStartTicketNo("");
        param.setSaleComputer("");
        param.setReserveId("");
        return param;
    }
}
