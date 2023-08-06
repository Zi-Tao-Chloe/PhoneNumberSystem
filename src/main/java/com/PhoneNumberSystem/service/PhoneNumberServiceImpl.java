package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.exception.NotFoundException;
import com.PhoneNumberSystem.repository.CustomerRepository;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    private PhoneNumberRepository phoneNumberRepository;
    private CustomerRepository customerRepository;

//    @Override
//    public List<PhoneNumber> getCustomerPhoneNumbers(Long customerId) {
//        Customer customer = customerRepository.findById(customerId).get();
//        return (List<PhoneNumber>) customer.getPhoneNumbers();
//    }

    @Override
    public List<PhoneNumber> getCustomerPhoneNumbers(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
                //.orElseThrow(() -> new NotFoundException("Customer not found with id: " + customerId));

        return (List<PhoneNumber>) customer.getPhoneNumbers();
    }


    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public void activatePhoneNumber(Long phoneNumberId) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(phoneNumberId).get();
        phoneNumber.setActivated(true);
    }

//  public List<Customer> getAllCustomer() {
//      return customerRepository.findAll();
//  }

}
