package com.ps.ccms.service;

import com.ps.ccms.models.Card;
import com.ps.ccms.repository.CreditCardRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepo creditCardRepo;

    public CreditCardServiceImpl(CreditCardRepo creditCardRepo) {
        this.creditCardRepo = creditCardRepo;
    }

    @Override
    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        creditCardRepo.findAll().forEach(card -> cards.add(card));
        return cards;
    }

    @Override
    public Card addNewCard(Card card) {
       return creditCardRepo.save(card);
    }
}
