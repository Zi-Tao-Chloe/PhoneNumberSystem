package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class PhoneNumberController {
    @Autowired
    private final PhoneNumberServiceImpl phoneNumberServiceImpl;

    public PhoneNumberController(final PhoneNumberServiceImpl phoneNumberServiceImpl) {
        this.phoneNumberServiceImpl = phoneNumberServiceImpl;
    }

    @GetMapping(value = "/phoneNumbers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllPhoneNumbers() {
        return ResponseEntity.ok(phoneNumberServiceImpl.getAllPhoneNumber());
    }

    @GetMapping(value = "/phoneNumbers/{phoneNumber_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void activatePhoneNumber(final @PathVariable long phoneNumber_id) {
        phoneNumberServiceImpl.activatePhoneNumber(phoneNumber_id);
    }
}
