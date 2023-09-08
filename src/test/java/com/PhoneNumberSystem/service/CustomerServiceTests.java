package com.PhoneNumberSystem.service;
import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    private static final long CUSTOMER_ID = 1L;

    @BeforeEach
    public void setUp() {
        customerServiceImpl = new CustomerServiceImpl(customerRepository);
    }

    @Test
    public void CustomerService_GetCustomerPhoneNumbers_ReturnCustomerPhoneNumbers() {
        // given
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        PhoneNumber phoneNumber1 = new PhoneNumber(5L, "0406961127", 1L, false);
        PhoneNumber phoneNumber2 = new PhoneNumber(6L, "0406961128", 1L, false);
        PhoneNumber phoneNumber3 = new PhoneNumber(7L, "0406961128", 1L, false);
        phoneNumberList.add(phoneNumber1);
        phoneNumberList.add(phoneNumber2);
        phoneNumberList.add(phoneNumber3);

        Customer customer = new Customer(CUSTOMER_ID, "Chloe", "Tao", phoneNumberList);

        /* When you directly call a method on a mock, like save, without any stubbing or setup, it doesn't have any
         real implementation. Mocks created by Mockito by default do nothing (they return default values like null,
         0, false, etc.) unless they are explicitly stubbed or spied upon. This means if you call save on the mock,
         it won't save anything or modify any state. If you expect certain behavior from the method, you need to stub
         that behavior first.*/

        // when
        when(customerRepository.findById(CUSTOMER_ID)).thenReturn(customer);

        List<PhoneNumber> phoneNumbers = customerServiceImpl.getCustomerPhoneNumbers(CUSTOMER_ID);

        // then
        Assertions.assertThat(phoneNumbers).isNotNull();
        assertEquals(3, phoneNumbers.size());
        verify(customerRepository, times(1)).findById(CUSTOMER_ID);
    }

    @Test
    public void CustomerService_Create_ReturnCreatedCustomer() {

        // given
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        PhoneNumber phoneNumber1 = new PhoneNumber(5L, "0406961127", 1L, false);
        PhoneNumber phoneNumber2 = new PhoneNumber(6L, "0406961128", 1L, false);
        PhoneNumber phoneNumber3 = new PhoneNumber(7L, "0406961128", 1L, false);
        phoneNumberList.add(phoneNumber1);
        phoneNumberList.add(phoneNumber2);
        phoneNumberList.add(phoneNumber3);

        Customer customer1 = new Customer(1L, "Chloe", "Tao", phoneNumberList);


        // when
        when(customerRepository.save(customer1)).thenReturn(customer1);

        Customer customer = customerServiceImpl.create(customer1);

        // then
        Assertions.assertThat(customer).isNotNull();

    }
}
