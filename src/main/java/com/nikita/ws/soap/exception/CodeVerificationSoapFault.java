package com.nikita.ws.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * <h1>CodeVerificationSoapFault</h1>
 * A class for return SoapFault exception.
 * @author Nikita
 */
@SoapFault(faultCode = FaultCode.SERVER)
public class CodeVerificationSoapFault extends Exception {


    /**
     * A constructor
     * @param message should be returned whenever that exception is thrown
     */
    public CodeVerificationSoapFault(String message) {
        super(message);
    }
}
