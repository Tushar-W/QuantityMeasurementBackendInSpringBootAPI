package com.bl.springboot.controller;

import com.bl.springboot.enums.Unit;
import com.bl.springboot.service.QuantityService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuantityMeasurementControllerTest {

    private List<Unit> units;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    QuantityService quantityService;

    @Test
    public void givenName_ShouldCheckStatusIsMatch() throws Exception {
        String unit = "Length";

        mockMvc.perform(
                get("/api/unit")
                        .param("unit", unit)
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void  givenUnitUrl_WhenCorrectUrl_ShouldReturnUnitList() throws Exception {
        when(quantityService.getUnitList()).thenReturn(units);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/units");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(200,mvcResult.getResponse().getStatus());
    }

}
