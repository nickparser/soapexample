# soapexample
simple SOAP-based web service.
A simple web service to verify the code of a certain template.

## technologies
- Java 8
- Maven
- Spring Framework (Boot, WS)
- OXM (JAXB2)

## run it
just run it in root application directory:
```
mvn spring-boot:run
```

## example
### input message
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:oper="http://operations.schema.soap.ws.nikita.com">
   <soapenv:Header/>
   <soapenv:Body>
      <oper:CodeVerificationRequest>
         <oper:code>12-333</oper:code>
      </oper:CodeVerificationRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### output message
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns3:CodeVerificationResponse xmlns:ns2="http://schema.soap.ws.nikita.com" xmlns:ns3="http://operations.schema.soap.ws.nikita.com">
         <ns3:VerificationResult>
            <ns2:result>successful verification!</ns2:result>
         </ns3:VerificationResult>
      </ns3:CodeVerificationResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SoapFault
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <SOAP-ENV:Fault>
         <faultcode>SOAP-ENV:Server</faultcode>
         <faultstring xml:lang="en">verification failed!</faultstring>
      </SOAP-ENV:Fault>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
