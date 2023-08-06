package com.PhoneNumberSystem.repository;

import com.PhoneNumberSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Object findByCustomerId(long l);
}
