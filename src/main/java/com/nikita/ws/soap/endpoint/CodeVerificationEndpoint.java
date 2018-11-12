package com.nikita.ws.soap.endpoint;

import com.nikita.ws.soap.exception.CodeVerificationSoapFault;
import com.nikita.ws.soap.schema.VerificationResult;
import com.nikita.ws.soap.schema.operations.CodeVerificationRequest;
import com.nikita.ws.soap.schema.operations.CodeVerificationResponse;
import com.nikita.ws.soap.service.CodeVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * <h1>CodeVerificationEndpoint</h1>
 * The endpoint of code verification service.
 * @author Nikita
 */
@Endpoint
public class CodeVerificationEndpoint {

    @Autowired
    private CodeVerificationService codeVerificationService;

    /**
     *
     * Get verification result
     *
     * @param request the code wrapped in CodeVerificationRequest object
     * @return VerificationResult object
     */
    @PayloadRoot(
            localPart = "CodeVerificationRequest",
            namespace = "http://operations.schema.soap.ws.nikita.com"
    )
    public @ResponsePayload CodeVerificationResponse verifyCode(
            @RequestPayload CodeVerificationRequest request
    ) throws CodeVerificationSoapFault {
        CodeVerificationResponse response = new CodeVerificationResponse();
        VerificationResult result = new VerificationResult();

        /* Call Spring injected service implementation to retrieve result */
        if(codeVerificationService.verifyCode(request.getCode())) {
            result.setResult("successful verification!");
        } else throw new CodeVerificationSoapFault("verification failed!");

        response.setVerificationResult(result);
        return response;
    }
}
