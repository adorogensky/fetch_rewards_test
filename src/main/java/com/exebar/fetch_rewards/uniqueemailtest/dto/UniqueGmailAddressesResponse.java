package com.exebar.fetch_rewards.uniqueemailtest.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class UniqueGmailAddressesResponse {

    private int uniqueEmailCount;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public int getUniqueEmailCount() {
        return uniqueEmailCount;
    }

    public void setUniqueEmailCount(int uniqueEmailCount) {
        this.uniqueEmailCount = uniqueEmailCount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        UniqueGmailAddressesResponse thatResponse = (UniqueGmailAddressesResponse) that;
        return uniqueEmailCount == thatResponse.uniqueEmailCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueEmailCount);
    }

    @Override
    public String toString() {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("toString() threw an exception", e);
        }
    }
}
