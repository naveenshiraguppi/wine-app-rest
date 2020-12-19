package com.challenge.wineapprest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BreakdownControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void apiBreakdownYear11YVCHAR001()
            throws Exception {

        mvc.perform(get("/api/breakdown/year/11YVCHAR001")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.breakDownType", is("year")))
                .andExpect(jsonPath("$.breakdown[0].percentage", is("85")))
                .andExpect(jsonPath("$.breakdown[0].key", is("2011")))
                .andExpect(jsonPath("$.breakdown[1].percentage", is("15")))
                .andExpect(jsonPath("$.breakdown[1].key", is("2010")))
        ;
    }

}
