package com.example.springjunittest5.controller;

import com.example.springjunittest5.SpringJunitTest5Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
@SpringBootTest(classes = SpringJunitTest5Application.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        Assert.notNull(webApplicationContext, "'webApplicationContext' must not be null");
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void hello() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name","world");
        ResultActions resultActions = mockMvc.perform(requestBuilder);
        resultActions.andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(status().is(200));
        resultActions.andExpect(content().string("hello world"));

    }
}
