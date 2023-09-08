package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.service.CustomerServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class CustomerController {
    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(final CustomerServiceImpl customerServiceImpl){
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping(value = "/customers/{customer_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCustomerPhoneNumbers(final @PathVariable long customer_id){
        return ResponseEntity.ok(customerServiceImpl.getCustomerPhoneNumbers(customer_id));
    }

    @PostMapping("/store_customer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerServiceImpl.create(customer);
    }


}
