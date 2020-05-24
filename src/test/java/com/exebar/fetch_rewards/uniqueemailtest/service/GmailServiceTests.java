package com.exebar.fetch_rewards.uniqueemailtest.service;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GmailServiceTests {

    GmailService gmailService = new GmailService();

    @Test
    void oneEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(singletonList("test.email@gmail.com")));
    }
}
