package com.example.mwdpassportbe.service;

import com.example.mwdpassportbe.request.RegistrationRequest;
import com.example.mwdpassportbe.response.Basic;
import org.springframework.http.ResponseEntity;

/**
 * @author maybaranikoko
 * @since 20-Mar-23
 * Purpose:
 */
public interface RegistrationService {

    ResponseEntity<Basic> createRegistration(RegistrationRequest registrationRequest);

}
