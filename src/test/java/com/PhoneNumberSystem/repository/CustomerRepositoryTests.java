package com.PhoneNumberSystem.repository;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    public void CustomerRepository_FindById_ReturnTheCustomer() {
        // given
        long customerId = 1L;
        Customer customer1 = new Customer(customerId, "Chloe", "Tao", null);

        // when
        customerRepository.save(customer1);
        Customer customer = customerRepository.findById(customer1.getId()).get();

        // then
        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isEqualTo(customerId);
    }
}
