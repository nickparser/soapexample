package com.nikita.ws.soap.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * <h1>CodeVerificationServiceImpl</h1>
 * A simple realization of CodeVerificationService interface
 * @author Nikita
 */
@Service
public class CodeVerificationServiceImpl implements CodeVerificationService {

    /* Default pattern (dd-ddd) TODO: Make better */
    private Pattern codePattern = Pattern.compile("\\d{2}-\\d{3}");

    /**
     * A concrete realization of code verification method
     *
     * @param code the code that you need to check
     * @return True or False wrapper
     */
    @Override
    public Boolean verifyCode(String code) {
        return codePattern.matcher(code).find();
    }
}
