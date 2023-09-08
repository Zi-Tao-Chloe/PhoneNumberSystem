package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.PhoneNumber;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getAllPhoneNumbers();
    void activatePhoneNumber(@PathVariable("id") long id);
    PhoneNumber create(PhoneNumber phoneNumber);
}
