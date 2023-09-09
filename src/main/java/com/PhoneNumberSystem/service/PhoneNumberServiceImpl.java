package com.PhoneNumberSystem.service;

import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.exception.AlreadyActivatedException;
import com.PhoneNumberSystem.exception.DuplicateDataException;
import com.PhoneNumberSystem.exception.InvalidPhoneNumberException;
import com.PhoneNumberSystem.exception.NotFoundException;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberServiceImpl.class);

    private final PhoneNumberRepository phoneNumberRepository;

    @Override
    public PhoneNumber create(PhoneNumber phoneNumber) {
        if (isValidPhoneNumber(phoneNumber.getPhoneNumber())) {
            logger.info("Valid phone number added: {}", phoneNumber.getPhoneNumber());
            try {
                // Attempt to save a phone number
                return phoneNumberRepository.save(phoneNumber);
            } catch (DataIntegrityViolationException e) {
                // Handle the unique constraint violation exception
                logger.error("Duplicate phone number: {}", phoneNumber.getPhoneNumber());
                throw new DuplicateDataException("Duplicate phone number found: " + phoneNumber.getPhoneNumber());
            }

        } else {
            logger.warn("Invalid phone number: {}", phoneNumber.getPhoneNumber());
            throw new InvalidPhoneNumberException("Invalid phone number: " + phoneNumber.getPhoneNumber());
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^04\\d{8}$");
    }


    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public void activatePhoneNumber(long phoneNumberId) {
        Optional<PhoneNumber> optionalPhoneNumber = phoneNumberRepository.findById(phoneNumberId);

        if (!optionalPhoneNumber.isPresent()){
            logger.warn("Attempt to activate a phone number that doesn't exist. Phone Number ID: {}", phoneNumberId);
            throw new NotFoundException("Phone number not found " + phoneNumberId);
        }

        if (optionalPhoneNumber.get().isActivated() == true) {
            logger.warn("The phone number has already been activated: {}", optionalPhoneNumber.get().getPhoneNumber());
            throw new AlreadyActivatedException("The phone number has already been activated: " + optionalPhoneNumber.get().getPhoneNumber());
        } else {
            optionalPhoneNumber.get().setActivated(true);
            phoneNumberRepository.save(optionalPhoneNumber.get());
            logger.info("The phone number has been successfully activated: {}", optionalPhoneNumber.get().getPhoneNumber());
        }
    }


}
