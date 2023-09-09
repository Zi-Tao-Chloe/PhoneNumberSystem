package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.exception.DuplicateDataException;
import com.PhoneNumberSystem.exception.NotFoundException;
import com.PhoneNumberSystem.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberServiceImpl.class);
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer){
        try {
            // Attempt to save a phone number
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            // Handle the unique constraint violation exception
            logger.error("Duplicate customer: {}", customer.getId());
            throw new DuplicateDataException("Duplicate customer found: " + customer.getId());
        }
    }
    @Override
    public List<PhoneNumber> getCustomerPhoneNumbers(long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (!optionalCustomer.isPresent()){
            logger.warn("Attempt to get a customer that doesn't exist. Customer ID: {}", customerId);
            throw new NotFoundException("Customer not found " + customerId);
        }

        return optionalCustomer.get().getPhoneNumbers();
    }
}
