package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    CustomerRepository customerRepository;

    @Override
    public List<PhoneNumber> getCustomerPhoneNumber(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return (List<PhoneNumber>) customer.getPhoneNumbers();
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumber() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void activatePhoneNumber(Long phoneNumberId) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(phoneNumberId).get();
        phoneNumber.setActivated(true);
    }
}
