package com.exebar.fetch_rewards.uniqueemailtest.service;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GmailServiceTests {

    private GmailService gmailService = new GmailService();

    @Test
    void oneEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(singletonList("test.email@gmail.com")));
    }

    @Test
    void twoEqualEmails_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(asList("test.email@gmail.com", "test.email@gmail.com")));
    }

    @Test
    void oneEmailWithDotAndOneEqualNormalizedEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(asList("test.email@gmail.com", "testemail@gmail.com")));
    }

    @Test
    void oneEmailWithPlusAndOneEqualNormalizedEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(asList("testemail+spam@gmail.com", "testemail@gmail.com")));
    }

    @Test
    void oneEmailWithDotAndOneEqualEmailWithPlusAndOneEqualNormalizedEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(asList("test.email@gmail.com", "testemail+spam@gmail.com", "testemail@gmail.com")));
    }

    @Test
    void oneEmailWithDotAndPlusAndOneEqualNormalizedEmail_getUniqueEmailCount_shoulReturn_1() {
        assertEquals(1, gmailService.getUniqueEmailCount(asList("test.email+spam@gmail.com", "testemail@gmail.com")));
    }

    @Test
    void oneEmailWithDotAndPlusAndOneEqualNormalizedEmailAndAnotherEmail_getUniqueEmailCount_shoulReturn_2() {
        assertEquals(2, gmailService.getUniqueEmailCount(asList("test.email+spam@gmail.com", "testemail@gmail.com", "test2.email@gmail.com")));
    }
}
