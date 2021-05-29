package com.ps.ccms.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void testLuhnFailure() {
        assertFalse(Validator.luhnCheck("5444333322221110"));
    }

    @Test
    void testLuhnSuccess() {
        assertTrue(Validator.luhnCheck("1358954993914435"));
    }

}