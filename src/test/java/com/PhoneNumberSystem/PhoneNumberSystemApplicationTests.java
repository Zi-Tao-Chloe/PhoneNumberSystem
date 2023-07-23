package com.PhoneNumberSystem;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.repository.CustomerRepository;
import com.PhoneNumberSystem.repository.PhoneNumberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PhoneNumberSystemApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private PhoneNumberRepository phoneNumberRepository;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getCustomers() {
		List<Customer> customerList = new ArrayList<>();
		Customer testCustomer1 = new Customer();
		testCustomer1.setFirstName("Chloe");
		testCustomer1.setLastName("Tao");
		testCustomer1.setId(1L);
		customerList.add(testCustomer1);

		Customer testCustomer2 = new Customer();
		testCustomer2.setFirstName("Paco");
		testCustomer2.setId(2L);
		testCustomer2.setLastName("Chen");
		customerList.add(testCustomer2);

		given(customerRepository.findAll()).willReturn(customerList);

		verify(customerRepository).findAll();
	}

}
