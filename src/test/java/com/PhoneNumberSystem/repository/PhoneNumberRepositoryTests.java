package com.PhoneNumberSystem.repository;

import com.PhoneNumberSystem.entity.PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PhoneNumberRepositoryTests {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    public void PhoneNumberRepository_Save_ReturnSavePhoneNumber() {

        // given
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "0406961127", 1L, false);
        phoneNumberList.add(phoneNumber1);

        // when
        PhoneNumber phoneNumber = phoneNumberRepository.save(phoneNumber1);

        // then
        Assertions.assertThat(phoneNumber).isNotNull();
        Assertions.assertThat(phoneNumber.getId()).isGreaterThan(0);
    }

    @Test
    public void PhoneNumberRepository_FindAll_ReturnAllPhoneNumber(){
        // given
        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "0406961127", 1L, false);
        PhoneNumber phoneNumber2 = new PhoneNumber(2L, "0406961128", 2L, false);

        // when
        phoneNumberRepository.save(phoneNumber1);
        phoneNumberRepository.save(phoneNumber2);
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.findAll();

        // then
        Assertions.assertThat(phoneNumberList).isNotNull();
        assertEquals(2, phoneNumberList.size());

    }

    @Test
    public void PhoneNumberRepository_FindById_ReturnThePhoneNumber() {
        // given
        long phoneId = 1L;
        PhoneNumber phoneNumber1 = new PhoneNumber(phoneId, "0406961127", 1L, false);

        // when
        phoneNumberRepository.save(phoneNumber1);
        PhoneNumber phoneNumber = phoneNumberRepository.findById(phoneNumber1.getId()).get();

        // then
        Assertions.assertThat(phoneNumber).isNotNull();
        Assertions.assertThat(phoneNumber.getId()).isEqualTo(phoneId);
    }


}
