package com.bl.springboot.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class QuantityMeasurementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenName_ShouldCheckStatusIsMatch() throws Exception {
        String unit = "Length";

        mockMvc.perform(
                get("/api/units")
                        .param("unit", unit)
        ).andExpect(
                status().isOk()
        );

    }


}
