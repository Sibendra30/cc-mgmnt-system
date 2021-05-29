package com.ps.ccms.controller;

import com.ps.ccms.exception.InvalidCCNumberException;
import com.ps.ccms.api.CreditCardAPI;
import com.ps.ccms.models.Card;
import com.ps.ccms.service.CreditCardService;
import com.ps.ccms.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreditCardController implements CreditCardAPI {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public ResponseEntity<List<Card>> getCards() {
        List<Card> cards;
        try {
            cards = creditCardService.getCards();
        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Card> addNewCard(Card card) {
        Card updatedCard;
        if (!Validator.luhnCheck(card.getCcNumber())) {
            throw new InvalidCCNumberException("Invalid credit card number");
        }
        try {
            updatedCard = creditCardService.addNewCard(card);
        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(updatedCard, HttpStatus.CREATED);
    }

}
