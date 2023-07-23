package com.PhoneNumberSystem.repository;

import com.PhoneNumberSystem.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
