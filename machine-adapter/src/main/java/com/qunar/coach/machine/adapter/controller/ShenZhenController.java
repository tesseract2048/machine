package com.qunar.coach.machine.adapter.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.qunar.coach.machine.adapter.service.ShenZhenService;
import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.core.model.ResponseCode;
import com.szlw.station.dto.ret.ReturnMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author weixin.gong
 * @date 15-11-18 下午8:17
 */
@RestController
public class ShenZhenController {

    @Resource
    private ShenZhenService shenZhenService;

    @RequestMapping("/search/tickets")
    public APIResponse<Map<String, Object>> searchTickets(String idCard, String password, String orderNo) {
        try {
            Preconditions.checkArgument(shenZhenService.validatorSearchTicketsParam(idCard, password, orderNo));
            List<ShenZhenTicketPrintBean> ticketInfoList = shenZhenService.searchTickets(idCard, password, orderNo);
            Map<String, Object> result = Maps.newHashMap();
            result.put("ticketInfoList", ticketInfoList);
            return APIResponse.success(result);
        } catch (IllegalArgumentException e) {
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/validator/ticket")
    public APIResponse<Map<String, Object>> validatorTicket(@RequestParam String ticketId) {
        try {
            Preconditions.checkArgument(shenZhenService.validatorTicketId(ticketId));
            return APIResponse.success();
        } catch (IllegalArgumentException e) {
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/printed/ticket")
    public APIResponse<Map<String, Object>> printedTicket(@RequestParam String ticketId) {
        try {
            Preconditions.checkArgument(shenZhenService.validatorTicketId(ticketId));
            ReturnMsg returnMsg = shenZhenService.printedTicket(ticketId);
            return APIResponse.success();
        } catch (IllegalArgumentException e) {
            return APIResponse.failed(ResponseCode.REQUEST_PARAM_ERROR);
        } catch (Exception e) {
            return APIResponse.failed(ResponseCode.SYSTEM_ERROR);
        }
    }


}
