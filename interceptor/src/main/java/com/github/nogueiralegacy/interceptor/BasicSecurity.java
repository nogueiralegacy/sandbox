package com.github.nogueiralegacy.interceptor;

import ca.uhn.fhir.i18n.Msg;
import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.exceptions.AuthenticationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;


@Interceptor
public class BasicSecurity {

    /**
     * A requisição abaixo, via httpie, deve funcionar
     * http -a servidor:fhir http://localhost:8080/fhir/Patient/1
     */
    @Hook(Pointcut.SERVER_INCOMING_REQUEST_POST_PROCESSED)
    public boolean incomingRequestPostProcessed(
            RequestDetails theRequestDetails, HttpServletRequest theRequest, HttpServletResponse theResponse)
            throws AuthenticationException {
        String authHeader = theRequest.getHeader("Authorization");

        // The format of the header must be:
        // Authorization: Basic [base64 of username:password]
        if (authHeader == null || authHeader.startsWith("Basic ") == false) {
            throw new AuthenticationException(Msg.code(642) + "Missing or invalid Authorization header");
        }

        String base64 = authHeader.substring("Basic ".length());
        String base64decoded = new String(Base64.decodeBase64(base64));
        String[] parts = base64decoded.split(":");

        String username = parts[0];
        String password = parts[1];

        if (!username.equals("servidor") || !password.equals("fhir")) {
            throw new AuthenticationException(Msg.code(643) + "Invalid username or password");
        }

        // Return true to allow the request to proceed
        return true;
    }
}