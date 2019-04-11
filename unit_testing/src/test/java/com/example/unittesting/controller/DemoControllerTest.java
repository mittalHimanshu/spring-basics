package com.example.unittesting.controller;

import com.example.unittesting.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HelloService helloService;

    @InjectMocks
    private DemoController demoController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    public void returnHello() throws Exception {

        Mockito.when(helloService.returnHello()).thenReturn("hello");

        mockMvc.perform(get("/demo"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void returnJson() throws  Exception{
        mockMvc.perform(get("/demo/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("Himanshu")))
                .andExpect(jsonPath("$.rollNo", Matchers.is("1610991368")));
    }

    @Test
    public void testPost() throws Exception {
        String json = "{\n" +
                "  \"name\": \"Himanshu Mittal\",\n" +
                "  \"rollNo\": \"1610991368\"\n" +
                "}";

        mockMvc.perform(post("/demo/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("Himanshu Mittal")))
                .andExpect(jsonPath("$.rollNo", Matchers.is("1610991368")));

    }
}