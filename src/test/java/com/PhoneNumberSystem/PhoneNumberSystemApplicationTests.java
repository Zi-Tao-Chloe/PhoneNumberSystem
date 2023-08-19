package com.PhoneNumberSystem;
import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ExtendWith(MockitoExtension.class)
class PhoneNumberSystemApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private PhoneNumberRepository phoneNumberRepository;

	// private AutoCloseable autoCloseable; - using extension

	private PhoneNumberServiceImpl phoneNumberServiceImpl;
	private static final long CUSTOMER_ID = 1L;
	private static final long PHONE_NUMBER_ID = 1L;

	@BeforeEach
	public void setUp() {
		// autoCloseable = MockitoAnnotations.openMocks(this); - using extension
		phoneNumberServiceImpl = new PhoneNumberServiceImpl(phoneNumberRepository, customerRepository);
	}

	/* @AfterEach - using extension
	public void teardown() throws Exception {
		autoCloseable.close(); // allow to close the resource after each test
	} */

	@Test
	public void itShouldCheckGetAllPhoneNumbers() {

		// Test phoneNumberRepository as well as phoneNumberService

		// given
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		PhoneNumber phoneNumber1 = new PhoneNumber(1L, "0406961127", 1L, false);
		PhoneNumber phoneNumber2 = new PhoneNumber(2L, "0406961128", 2L, false);
		phoneNumberList.add(phoneNumber1);
		phoneNumberList.add(phoneNumber2);

		// when
		when(phoneNumberRepository.findAll()).thenReturn(phoneNumberList);
		// when its findAll() method is called during the test execution, it will return the
		// phoneNumberList rather than executing any real logic or interacting with any real underlying
		// resources (like a database)

		List<PhoneNumber> phoneNumbers = phoneNumberServiceImpl.getAllPhoneNumbers();

		// then
		assertEquals(2, phoneNumbers.size());
		verify(phoneNumberRepository, times(1)).findAll();

		// Test only phoneNumberService as there is no need to test repository in this case

		// when
		// phoneNumberServiceImpl.getAllPhoneNumbers();
		// then
		// verify(phoneNumberRepository).findAll(); // to verify this repository is invoked using the method findAll()
	}

	@Test
	public void itShouldCheckGetCustomerPhoneNumbers() {
		// given
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		PhoneNumber phoneNumber1 = new PhoneNumber(5L, "0406961127", 1L, false);
		PhoneNumber phoneNumber2 = new PhoneNumber(6L, "0406961128", 1L, false);
		phoneNumberList.add(phoneNumber1);
		phoneNumberList.add(phoneNumber2);

		Customer customer = new Customer(1L, "Chloe", "Tao", phoneNumberList);
		//customerRepository.save(customer);

		// when
		when(customerRepository.findById(CUSTOMER_ID)).thenReturn(customer);
		// ?when(customerRepository.findById(CUSTOMER_ID).getPhoneNumbers()).thenReturn(phoneNumberList);？

		List<PhoneNumber> phoneNumbers = phoneNumberServiceImpl.getCustomerPhoneNumbers(CUSTOMER_ID);

		// then
		assertEquals(2, phoneNumbers.size());
		verify(customerRepository, times(1)).findById(CUSTOMER_ID);
	}


	@Test
	void itShouldCheckActivatePhoneNumber() {
		// given
		PhoneNumber phoneNumber = new PhoneNumber(1L, "0406961127", 1L, false);

		// when
		when(phoneNumberRepository.findById(PHONE_NUMBER_ID)).thenReturn(phoneNumber);
		phoneNumberServiceImpl.activatePhoneNumber(PHONE_NUMBER_ID);

		// then
		PhoneNumber phoneNumberTest = phoneNumberRepository.findById(PHONE_NUMBER_ID);
		assertTrue(phoneNumberTest.isActivated());
		verify(phoneNumberRepository, times(2)).findById(PHONE_NUMBER_ID);
	}


}
