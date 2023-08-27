package com.PhoneNumberSystem.controller;

import com.PhoneNumberSystem.entity.PhoneNumber;
import com.PhoneNumberSystem.service.PhoneNumberServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(controllers = PhoneNumberController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class PhoneNumberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneNumberServiceImpl phoneNumberServiceImpl;


    @Test
    public void PhoneNumberController_GetAllPhoneNumber_ReturnAllPhoneNumber() throws Exception {
        List<PhoneNumber> phoneNumberList = Arrays.asList(new PhoneNumber(1L, "0406961127", 1L,
                false), new PhoneNumber(2L, "0406961128", 2L, false));
        when(phoneNumberServiceImpl.getAllPhoneNumbers()).thenReturn(phoneNumberList);
        ResultActions response = mockMvc.perform(get("/v1/phoneNumbers")
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber", CoreMatchers.is("0406961127")));
    }

    @Test
    public void PhoneNumberController_ActivatePhoneNumber_ActivatePhoneNumber() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber(1L, "0406961127", 1L, false);
        doNothing().when(phoneNumberServiceImpl).activatePhoneNumber(1L);
        ResultActions response = mockMvc.perform(put("/v1/phoneNumbers/{phoneNumber_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

}
