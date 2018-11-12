package com.nikita.ws.soap.service;

/**
 *  <h1>CodeVerificationService</h1>
 *  A simple interface for code verification.
 *  @author Nikita
*/
public interface CodeVerificationService {

    /**
     * Code verification method
     *
     * @param code the code that you need to check
     * @return True or False wrapper
     */
    Boolean verifyCode(String code);
}
