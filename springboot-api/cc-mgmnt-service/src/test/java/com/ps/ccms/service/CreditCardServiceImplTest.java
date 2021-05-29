package com.ps.ccms.service;

import com.ps.ccms.models.Card;
import com.ps.ccms.repository.CreditCardRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardServiceImplTest {

    @MockBean
    CreditCardRepo creditCardRepo;

    CreditCardService creditCardService;

    @BeforeEach
    void setup() {
        creditCardService = new CreditCardServiceImpl(creditCardRepo);
    }

    @Test
    void getCards() {
        when(creditCardRepo.findAll())
                .thenReturn(Collections.singletonList(
                        new Card("testName", "1358954993914435", 0.0, 900.0)));
        List<Card> cards = creditCardService.getCards();
        assertEquals(1, cards.size());
        verify(creditCardRepo).findAll();
    }

    @Test
    void addCards() {
        Card card = new Card("testName", "1358954993914435", 0.0, 900.0);
        when(creditCardRepo.save(eq(card)))
                .thenReturn(new Card("testName", "1358954993914435", 0.0, 900.0));
        Card addedCard = creditCardService.addNewCard(card);
        assertEquals(card, addedCard);
        verify(creditCardRepo).save(eq(card));
    }

}