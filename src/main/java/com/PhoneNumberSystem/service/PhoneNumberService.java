package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.temporal.ChronoUnit;
import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getCustomerPhoneNumber(@PathVariable("id") Long customerId);
    List<PhoneNumber> getAllPhoneNumber();
    List<Customer> getAllCustomer();
    void activatePhoneNumber(@PathVariable("id") Long id);
}
