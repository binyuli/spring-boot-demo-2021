package com.example.demo.jpa.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class JpaControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeAll
    public static void init() {
        System.out.println("Before All test...");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before Each test");
    }

    @Test
    public void testControllerOK() throws Exception {
        System.out.println("Test Controller");
        mvc.perform(MockMvcRequestBuilders.get("/jpa/stock/name/Computer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void testControllerParamError() {
        System.out.println("Test Controller with Param Error");
        try {
            mvc.perform(MockMvcRequestBuilders.get("/jpa/stock/name/error"))
                    .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                    .andReturn();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Param is error"));
        }
    }

    @Test
    public void testControllerResultError() throws Exception {
        System.out.println("Test Controller with Result Error");
        try {
            mvc.perform(MockMvcRequestBuilders.get("/jpa/stock/name/empty"))
                    .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                    .andReturn();
        } catch (Exception e) {
            assertTrue(e.getMessage().indexOf("No Stock") != -1);
        }
    }

}