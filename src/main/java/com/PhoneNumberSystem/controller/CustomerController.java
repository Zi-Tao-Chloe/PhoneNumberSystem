package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.service.PhoneNumberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class CustomerController {
    private final PhoneNumberService phoneNumberService;

    public CustomerController(final PhoneNumberService phoneNumberService){
        this.phoneNumberService = phoneNumberService;
    }
}
