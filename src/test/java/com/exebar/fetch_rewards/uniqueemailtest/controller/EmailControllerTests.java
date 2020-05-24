package com.exebar.fetch_rewards.uniqueemailtest.controller;

import com.exebar.fetch_rewards.uniqueemailtest.dto.UniqueGmailAddressesRequest;
import com.exebar.fetch_rewards.uniqueemailtest.dto.UniqueGmailAddressesResponse;
import com.exebar.fetch_rewards.uniqueemailtest.service.GmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmailController.class)
class EmailControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    GmailService emailService;

    @Test
    void endpointInputOutputTest() throws Exception {
        UniqueGmailAddressesRequest uniqueGmailAddressRequest = new UniqueGmailAddressesRequest();
        uniqueGmailAddressRequest.setEmailList(
                Arrays.asList(
                        "test.email@gmail.com",
                        "test.email+spam@gmail.com",
                        "testemail@gmail.com"
                )
        );

        UniqueGmailAddressesResponse expectedUniqueGmailAddressResponse = new UniqueGmailAddressesResponse();
        expectedUniqueGmailAddressResponse.setUniqueEmailCount(1);

        when(emailService.getUniqueEmailCount()).thenReturn(1);

        String actualUniqueGmailAddressesResponseAsJson = mockMvc.perform(
                get("/email/gmail/unique")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(
                                objectMapper.writeValueAsString(
                                        uniqueGmailAddressRequest
                                )
                        )
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse().getContentAsString();

        assertEquals(
                expectedUniqueGmailAddressResponse,
                objectMapper.readValue(
                        actualUniqueGmailAddressesResponseAsJson,
                        UniqueGmailAddressesResponse.class
                )
        );
    }
}
