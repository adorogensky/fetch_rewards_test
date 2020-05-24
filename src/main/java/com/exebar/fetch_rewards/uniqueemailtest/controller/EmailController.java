package com.exebar.fetch_rewards.uniqueemailtest.controller;

import com.exebar.fetch_rewards.uniqueemailtest.dto.UniqueGmailAddressesRequest;
import com.exebar.fetch_rewards.uniqueemailtest.dto.UniqueGmailAddressesResponse;
import com.exebar.fetch_rewards.uniqueemailtest.service.GmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private GmailService gmailService;

    public EmailController(GmailService gmailService) {
        this.gmailService = gmailService;
    }

    @PostMapping("/email/gmail/unique")
    public UniqueGmailAddressesResponse findUniqueGmailAddresses(@RequestBody UniqueGmailAddressesRequest request) {
        UniqueGmailAddressesResponse response = new UniqueGmailAddressesResponse();
        response.setUniqueEmailCount(gmailService.getUniqueEmailCount(request.getEmailList()));
        return response;
    }
}
