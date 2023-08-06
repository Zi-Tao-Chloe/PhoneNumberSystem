package com.PhoneNumberSystem;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhoneNumberSystemApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private PhoneNumberRepository phoneNumberRepository;

	@InjectMocks
	private PhoneNumberServiceImpl phoneNumberServiceImpl;
	private static final long CUSTOMER_ID = 1L;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllPhoneNumbersTest() {
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		phoneNumberList.add(new PhoneNumber(1L, "0406961127", 1L, false));
		phoneNumberList.add(new PhoneNumber(2L, "0406961128", 2L, false));

		when(phoneNumberRepository.findAll()).thenReturn(phoneNumberList);

		List<PhoneNumber> phoneNumbers = phoneNumberServiceImpl.getAllPhoneNumbers();

		assertEquals(2, phoneNumbers.size());
		verify(phoneNumberRepository, times(1)).findAll();
	}

	@Test
	public void getCustomerPhoneNumbers() {
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		phoneNumberList.add(new PhoneNumber(5L, "0406961127", 1L, false));
		phoneNumberList.add(new PhoneNumber(6L, "0406961128", 1L, false));

		when(phoneNumberRepository.findByCustomerId(CUSTOMER_ID)).thenReturn(phoneNumberList);

		List<PhoneNumber> phoneNumbers = phoneNumberServiceImpl.getCustomerPhoneNumbers(CUSTOMER_ID);

		assertEquals(2, phoneNumbers.size());
		verify(phoneNumberRepository, times(1)).findByCustomerId(CUSTOMER_ID);
	}


	@Test
	void activatePhoneNumberTest() {
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		phoneNumberList.add(new PhoneNumber(1L, "0406961127", 1L, false));
		phoneNumberList.add(new PhoneNumber(2L, "0406961128", 2L, false));

		when(phoneNumberRepository.findById(anyLong())).thenReturn(Optional.ofNullable(phoneNumberList.get(0)));

		phoneNumberServiceImpl.activatePhoneNumber(anyLong());

		// Verify the results
		PhoneNumber phoneNumber = phoneNumberRepository.findById(anyLong()).get();
		assertTrue(phoneNumber.isActivated());
		//verify(phoneNumberRepository, times(1)).findById(anyLong());
	}


}
