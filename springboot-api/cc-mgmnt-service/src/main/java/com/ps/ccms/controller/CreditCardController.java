package com.ps.ccms.controller;

import com.ps.ccms.exception.InvalidCCNumberException;
import com.ps.ccms.api.CreditCardAPI;
import com.ps.ccms.models.Card;
import com.ps.ccms.service.CreditCardService;
import com.ps.ccms.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController implements CreditCardAPI {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<>(creditCardService.getCards(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Card> addNewCard(Card card) {
        if (!Validator.luhnCheck(card.getCcNumber())) {
            throw new InvalidCCNumberException("Invalid credit card number");
        }
        return new ResponseEntity<>( creditCardService.addNewCard(card), HttpStatus.CREATED);
    }

}
