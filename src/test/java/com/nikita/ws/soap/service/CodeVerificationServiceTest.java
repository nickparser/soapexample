package com.nikita.ws.soap.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CodeVerificationServiceTest {

    CodeVerificationService codeVerificationService;

    @Before
    public void init() {
        codeVerificationService = new CodeVerificationServiceImpl();
    }

    @Test
    public void verifiCode() {

        //successful verification
        assertTrue(codeVerificationService.verifyCode("44-555"));

        //verification failed
        assertTrue(!codeVerificationService.verifyCode("sdf5-4d5fg"));
    }
}