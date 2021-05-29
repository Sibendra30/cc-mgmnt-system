package com.ps.ccms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.ccms.models.Card;
import com.ps.ccms.service.CreditCardService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

@WebMvcTest(CreditCardController.class)
class CreditCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditCardService creditCardService;

    @Test
    void getCards() throws Exception {
        when(creditCardService.getCards()).thenReturn(
                Collections.singletonList(new Card("testName", "1358954993914435", 0.0, 900.0)));
        mockMvc.perform(MockMvcRequestBuilders.get("/cards"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is("testName")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].ccNumber", Matchers.is("1358954993914435")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].balance", Matchers.is(0.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].limit", Matchers.is(900.0)))
                .andReturn();

        verify(creditCardService, times(1)).getCards();
    }

    @Test
    void getCards500Status() throws Exception {
        when(creditCardService.getCards()).thenThrow(new RuntimeException("Internal Server Error"));
        mockMvc.perform(MockMvcRequestBuilders.get("/cards"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andReturn();

        verify(creditCardService, times(1)).getCards();
    }

    @Test
    void addCard() throws Exception {
        Card card = new Card("testName", "1358954993914435", 0.0, 900.0);
        when(creditCardService.addNewCard(eq(card))).thenReturn(new Card("testName", "1358954993914435", 0.0, 900.0));
        mockMvc.perform(MockMvcRequestBuilders.post("/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(card)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andReturn();
    }

    @Test
    void addCard_ccLuhnCheckFailed() throws Exception {
        Card card = new Card("testName", "1358954993914437", 0.0, 900.0);
        mockMvc.perform(MockMvcRequestBuilders.post("/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(card)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()))
                .andReturn();
    }

    @Test
    void addCard500Status() throws Exception {
        Card card = new Card("testName", "1358954993914435", 0.0, 900.0);
        when(creditCardService.addNewCard(eq(card))).thenThrow(new RuntimeException("Internal Server Error"));
        mockMvc.perform(MockMvcRequestBuilders.post("/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(card)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .andReturn();
    }

}