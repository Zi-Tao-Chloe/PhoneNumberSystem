package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class CustomerController {
    private final PhoneNumberServiceImpl phoneNumberServiceImpl;

    public CustomerController(final PhoneNumberServiceImpl phoneNumberServiceImpl){
        this.phoneNumberServiceImpl = phoneNumberServiceImpl;
    }

    @GetMapping(value = "/customers/{customer_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCustomerPhoneNumbers(final @PathVariable long customer_id){
        return ResponseEntity.ok(phoneNumberServiceImpl.getCustomerPhoneNumbers(customer_id));
    }

//    @GetMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<?> getAllCustomers() {return ResponseEntity.ok(phoneNumberServiceImpl.getAllCustomer());}

}
