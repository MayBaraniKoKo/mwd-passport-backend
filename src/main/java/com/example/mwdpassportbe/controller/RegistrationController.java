package com.example.mwdpassportbe.controller;

import com.example.mwdpassportbe.request.RegistrationRequest;
import com.example.mwdpassportbe.response.Basic;
import com.example.mwdpassportbe.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author maybaranikoko
 * @since 20-Mar-23
 * Purpose:
 */
@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/v1")
@Slf4j
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping(value = "/create-registration")
    public ResponseEntity<Basic> createRegistration(@RequestBody RegistrationRequest registrationRequest) {
        try {
            long time = System.currentTimeMillis();
            ResponseEntity<Basic> response = registrationService.createRegistration(registrationRequest);
            log.info("[{} ms] api/create-registration", System.currentTimeMillis() - time);
            return response;
        } catch (Exception e) {
            log.error("Error when process: {}, {}", e.getClass().getSimpleName(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
