package com.stpan.springstudy.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void userList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userList"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/testTest"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
        String s = result.getResponse().getContentAsString();
        Map<String,Object> user = (Map<String, Object>) JSONUtils.parse(s);
        System.out.println("-------------"+user.get("id"));

    }
}