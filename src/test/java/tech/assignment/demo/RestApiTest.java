package tech.assignment.demo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import tech.assignment.demo.service.CountryService;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class RestApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CountryService service;
    
    @Test
    @Order(1)
    public void canGetIndividual() throws JsonProcessingException, Exception {
        mockMvc
        .perform(get("/api/countries?country=afghanistan"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$[0].name").value("Afghanistan"));
    }

    @Test
    @Order(2)
    public void canGetAllAndCheckFirstCountry() throws JsonProcessingException, Exception {
        mockMvc
        .perform(get("/api/countries"))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$[0].name").value("Afghanistan"))
        .andExpect(jsonPath("$[0].countryCode").value("AF"));

    }
}
