package com.ps.ccms.api;

import com.ps.ccms.models.Card;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RequestMapping("/cards")
@Produces("application/json")
public interface CreditCardAPI {

    @GetMapping
    ResponseEntity<List<Card>> getCards();

    @PostMapping
    @Consumes("application/json")
    ResponseEntity<Card> addNewCard(@Validated @RequestBody Card requestBody);
}
