package com.ps.ccms.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void testLuhnSuccess() {
        assertFalse(Validator.luhnCheck("4444333322221110"));
    }

    @Test
    void testLuhnFailure() {
        assertTrue(Validator.luhnCheck("4444333322221111"));
    }

}