package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.entity.Customer;
import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.service.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceImpl customerServiceImpl;

    @Test
    public void CustomerController_GetCustomerPhoneNumber_ReturnCustomerPhoneNumber() throws Exception{
        List<PhoneNumber> phoneNumberList = Arrays.asList(new PhoneNumber(1L, "0406961127", 1L,
                false), new PhoneNumber(2L, "0406961128", 1L, false));
        Customer customer = new Customer(1L, "Chloe", "Tao", phoneNumberList);
        when(customerServiceImpl.getCustomerPhoneNumbers(1L)).thenReturn(phoneNumberList);
        ResultActions response = mockMvc.perform(get("/v1/customers/{customer_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", CoreMatchers.is("0406961127")));
        }

}
