package com.ps.ccms.service;

import com.ps.ccms.models.Card;

import java.util.List;

public interface CreditCardService {

    List<Card> getCards();
    Card addNewCard(Card card);
}
