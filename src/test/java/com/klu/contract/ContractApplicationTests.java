package com.klu.contract;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdditionController.class)
class ContractApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AdditionService service;

    @Test
    void testAdditionEndpoint() throws Exception {

        when(service.add(5, 10)).thenReturn(15);

        mockMvc.perform(get("/ms1/add")
                .param("a", "5")
                .param("b", "10"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15));
    }
    
    @Test
    void testAdditionWithNegativeNumbers() throws Exception {

        when(service.add(-5, 10)).thenReturn(5);

        mockMvc.perform(get("/ms1/add")
                .param("a", "-5")
                .param("b", "10"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }
}