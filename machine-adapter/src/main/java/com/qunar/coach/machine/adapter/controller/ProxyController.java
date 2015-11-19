package com.qunar.coach.machine.adapter.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.ResponseCode;
import com.szlw.station.dto.SearchElecTicketInfoDto;
import com.szlw.station.dto.param.AutoReticketSelInfoParam;
import com.szlw.station.dto.param.AutoSellResticketInfoParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author weixin.gong
 * @date 15-11-18 下午8:17
 */
@RestController
public class ProxyController {

    //private final StationAgent stationAgent = StationAgentFactory.getStationAgent();

    @RequestMapping("/search/order")
    public APIResponse<Map<String, Object>> searchOrder(@RequestParam String idCard,
                                                        @RequestParam String password,
                                                        @RequestParam String orderNo) {
        try {
            Preconditions.checkArgument(validatorSearchOrdersParam(idCard, password, orderNo));
            AutoReticketSelInfoParam param = newAutoReticketSelInfoParam(idCard, password, orderNo);
            @SuppressWarnings("unchecked")
            //List<SearchElecTicketInfoDto> ticketInfoList = stationAgent.searchElecTicket(param);
            List<SearchElecTicketInfoDto> ticketInfoList = mock();
            Map<String, Object> result = Maps.newHashMap();
            result.put("ticketInfoList", toBeanList(ticketInfoList));
            return APIResponse.success(result);
        } catch (IllegalArgumentException e) {
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
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
        ticketInfoDto.setPtrResticketMasterId(1);
        ticketInfoDto.setSequenceNo("001");
        ticketInfoDto.setBusType("普通");
        list.add(ticketInfoDto);
        return list;
    }

    private List<ShenZhenTicketPrintBean> toBeanList(List<SearchElecTicketInfoDto> ticketInfoList) {
        List<ShenZhenTicketPrintBean> list = Lists.newArrayList();
        for (SearchElecTicketInfoDto ticketInfoDto : ticketInfoList) {
            list.add(toBean(ticketInfoDto));
        }
        return list;
    }

    private ShenZhenTicketPrintBean toBean(SearchElecTicketInfoDto ticketInfoDto) {
        ShenZhenTicketPrintBean bean = new ShenZhenTicketPrintBean();
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
        bean.setTicketId(ticketInfoDto.getSequenceNo());
        bean.setType(ticketInfoDto.getBusType());
        return bean;
    }

    private AutoReticketSelInfoParam newAutoReticketSelInfoParam(String idCard, String password, String orderNo) {
        AutoReticketSelInfoParam param = new AutoReticketSelInfoParam();
        param.setIcardCode(idCard);
        param.setPwd(password);
        param.setBillNo(orderNo);
        return param;
    }

    private boolean validatorSearchOrdersParam(String idCard, String password, String orderNo) {
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


    @RequestMapping("/printed/ticket")
    public APIResponse<Map<String, Object>> searchOrder(@RequestParam String idCard) {
        try {
            AutoSellResticketInfoParam param = newAutoSellResticketInfoParam();
            //ReturnMsg returnMsg = stationAgent.autoSellResticket(param);
            return APIResponse.success();
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
    }

    private AutoSellResticketInfoParam newAutoSellResticketInfoParam() {
        AutoSellResticketInfoParam param = new AutoSellResticketInfoParam();
        return param;
    }
}
