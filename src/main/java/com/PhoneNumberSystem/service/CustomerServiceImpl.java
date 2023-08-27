package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public List<PhoneNumber> getCustomerPhoneNumbers(long customerId) {
        Customer customer = customerRepository.findById(customerId);

        return customer.getPhoneNumbers();
    }
}
