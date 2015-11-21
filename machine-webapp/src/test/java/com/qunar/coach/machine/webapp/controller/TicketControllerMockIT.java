package com.qunar.coach.machine.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.qunar.coach.machine.core.mode.ShenZhenTicketPrintBean;
import com.qunar.coach.machine.core.model.APIResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by niuli on 11/21/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:applicationContext-webapp.xml")
public class TicketControllerMockIT {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getFoo() throws Exception {
        APIResponse<List<ShenZhenTicketPrintBean>> response = new APIResponse<>(
                200, "1234", (List<ShenZhenTicketPrintBean>) Lists.newArrayList(new ShenZhenTicketPrintBean())
        );

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/ticket/report_ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(response)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
