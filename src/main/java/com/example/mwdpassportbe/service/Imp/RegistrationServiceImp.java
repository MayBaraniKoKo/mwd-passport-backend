package com.example.mwdpassportbe.service.Imp;

import com.example.mwdpassportbe.repo.RegistrationRepo;
import com.example.mwdpassportbe.request.RegistrationRequest;
import com.example.mwdpassportbe.response.Basic;
import com.example.mwdpassportbe.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author maybaranikoko
 * @since 20-Mar-23
 * Purpose:
 */
@Slf4j
@Service
public class RegistrationServiceImp implements RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public ResponseEntity<Basic> createRegistration(RegistrationRequest registrationRequest) {
        return null;
    }

}
