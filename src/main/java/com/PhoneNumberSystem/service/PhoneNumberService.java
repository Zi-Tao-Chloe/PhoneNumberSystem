package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getCustomerPhoneNumbers(@PathVariable("id") Long customerId);
    List<PhoneNumber> getAllPhoneNumbers();
    //TODO: List<Customer> getAllCustomer();
    void activatePhoneNumber(@PathVariable("id") Long id);
}
