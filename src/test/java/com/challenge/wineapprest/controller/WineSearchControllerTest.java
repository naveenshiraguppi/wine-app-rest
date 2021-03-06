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
class WineSearchControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void serchWithLotCode()
            throws Exception {

        mvc.perform(get("/api/search/20")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].lotCode", is("11YVCHAR001")))
                .andExpect(jsonPath("$.[1].lotCode", is("15MPPN002-VK")))
        ;
    }
    @Test
    public void serchWithLotDescription()
            throws Exception {

        mvc.perform(get("/api/search/2015 Mornington Peninsula Pinot Noir")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].lotCode", is("15MPPN002-VK")))
        ;
    }
    @Test
    public void serchWithLotDescription_null()
            throws Exception {

        mvc.perform(get("/api/search/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
        ;
    }
}
