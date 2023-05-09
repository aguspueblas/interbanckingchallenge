/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.challenge.interbanking.xontroller;

import com.challenge.interbanking.InterbankingApplication;
import com.challenge.interbanking.controllers.CompanyController;
import com.challenge.interbanking.dtos.CompanyDto;
import com.challenge.interbanking.services.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Agustin Pueblas
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {InterbankingApplication.class})
@WebAppConfiguration
public class CompanyControllerTest {

    @MockBean
    private CompanyService companyServiceMock;

    @Autowired
    private CompanyController companyController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    public CompanyControllerTest() {
    }

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void findAll_ShouldReturnAllCompanies() throws Exception {
        // Arrange
        List<CompanyDto> expectedCompanies = new ArrayList<>();
        expectedCompanies.add(new CompanyDto());
        expectedCompanies.add(new CompanyDto());
        Mockito.when(companyServiceMock.findAll()).thenReturn(new ResponseEntity<List<CompanyDto>>(expectedCompanies, HttpStatus.OK));

        MvcResult result = this.mockMvc.perform(get("/company")).andExpect(status().isOk()).andReturn();
        Integer status = result.getResponse().getStatus();
        String listResult = result.getResponse().getContentAsString();
        
        assertThat(status).isEqualTo(HttpStatus.OK.value());
        assertEquals(new ObjectMapper().writeValueAsString(expectedCompanies), listResult, true);
    }

}
