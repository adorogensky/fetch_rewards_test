package com.exebar.fetch_rewards.uniqueemailtest.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GmailService {

    public int getUniqueEmailCount(List<String> emails) {
        if (emails == null || emails.size() == 0) return 0;
        if (emails.size() == 1) return 1;

        return emails.stream().map(
                email -> email.substring(0, email.indexOf('@'))
        ).map(
                email -> email.replace(".", "")
        ).map(
                this::removeAllAfterPlus
        ).collect(Collectors.toSet()).size();
    }

    private String removeAllAfterPlus(String in) {
        int indexOfPlus = in.indexOf("+");
        return indexOfPlus != -1 ? in.substring(0, indexOfPlus) : in;
    }
}
