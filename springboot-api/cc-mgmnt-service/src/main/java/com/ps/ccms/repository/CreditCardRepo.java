package com.ps.ccms.repository;

import com.ps.ccms.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends CrudRepository<Card, String> {
}
