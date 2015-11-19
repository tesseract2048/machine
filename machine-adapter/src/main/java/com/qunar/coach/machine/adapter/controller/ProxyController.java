package com.qunar.coach.machine.adapter.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.qunar.coach.machine.adapter.factory.StationAgentFactory;
import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.ResponseCode;
import com.szlw.station.dto.SearchElecTicketInfoDto;
import com.szlw.station.dto.param.AutoReticketSelInfoParam;
import com.szlw.station.dto.param.AutoSellResticketInfoParam;
import com.szlw.station.dto.ret.ReturnMsg;
import com.szlw.station.sessions.interfaces.StationAgent;
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

    private final StationAgent stationAgent = StationAgentFactory.getStationAgent();

    @RequestMapping("/search/order")
    public APIResponse<Map<String, Object>> searchOrder(@RequestParam String idCard,
                                                        @RequestParam String password,
                                                        @RequestParam String orderNo) {
        try {
            Preconditions.checkArgument(validatorSearchOrdersParam(idCard, password, orderNo));
            AutoReticketSelInfoParam param = newAutoReticketSelInfoParam(idCard, password, orderNo);
            @SuppressWarnings("unchecked")
            List<SearchElecTicketInfoDto> ticketInfoList = stationAgent.searchElecTicket(param);
            Map<String, Object> result = Maps.newHashMap();
            result.put("ticketInfoList", ticketInfoList);
            return APIResponse.success(result);
        } catch (IllegalArgumentException e) {
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
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
        return true;
    }

    private boolean validatorOrderNo(String orderNo) {
        return true;
    }


    @RequestMapping("/printed/ticket")
    public APIResponse<Map<String, Object>> searchOrder(@RequestParam String idCard) {
        try {
            AutoSellResticketInfoParam param = newAutoSellResticketInfoParam();
            ReturnMsg returnMsg = stationAgent.autoSellResticket(param);
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
