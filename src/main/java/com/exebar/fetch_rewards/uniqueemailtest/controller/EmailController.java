package com.exebar.fetch_rewards.uniqueemailtest.controller;

import com.exebar.fetch_rewards.uniqueemailtest.dto.UniqueGmailAddressesResponse;
import com.exebar.fetch_rewards.uniqueemailtest.service.GmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private GmailService gmailService;

    public EmailController(GmailService gmailService) {
        this.gmailService = gmailService;
    }

    @GetMapping("/email/gmail/unique")
    public UniqueGmailAddressesResponse findUniqueGmailAddresses() {
        UniqueGmailAddressesResponse response = new UniqueGmailAddressesResponse();
        response.setUniqueEmailCount(gmailService.getUniqueEmailCount());
        return response;
    }
}
