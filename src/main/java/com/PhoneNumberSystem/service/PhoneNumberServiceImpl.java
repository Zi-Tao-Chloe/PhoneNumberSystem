package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.controller.PhoneNumberController;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    private final PhoneNumberRepository phoneNumberRepository;

    @Override
    public PhoneNumber create(PhoneNumber phoneNumber){
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public void activatePhoneNumber(long phoneNumberId) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        phoneNumber.setActivated(true);
    }


}
