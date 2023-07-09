package com.PhoneNumberSystem.repository;

import com.PhoneNumberSystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
