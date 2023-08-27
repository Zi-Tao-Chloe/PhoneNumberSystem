package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class PhoneNumberController {
    private final PhoneNumberServiceImpl phoneNumberServiceImpl;

    public PhoneNumberController(final PhoneNumberServiceImpl phoneNumberServiceImpl) {
        this.phoneNumberServiceImpl = phoneNumberServiceImpl;
    }

    @GetMapping(value = "/phoneNumbers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllPhoneNumbers() {
        return ResponseEntity.ok(phoneNumberServiceImpl.getAllPhoneNumbers());
    }

    @PutMapping(value = "/phoneNumbers/{phoneNumber_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void activatePhoneNumber(final @PathVariable long phoneNumber_id) {
        phoneNumberServiceImpl.activatePhoneNumber(phoneNumber_id);
    }
}
