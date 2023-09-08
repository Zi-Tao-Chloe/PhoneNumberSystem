package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerService {

    Customer create(Customer customer);
    List<PhoneNumber> getCustomerPhoneNumbers(@PathVariable("id") long customerId);
    //TODO: List<Customer> getAllCustomer();
}
