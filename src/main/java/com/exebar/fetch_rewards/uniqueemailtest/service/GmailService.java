package com.exebar.fetch_rewards.uniqueemailtest.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GmailService {

    public int getUniqueEmailCount(List<String> emails) {
        return emails.size();
    }
}
