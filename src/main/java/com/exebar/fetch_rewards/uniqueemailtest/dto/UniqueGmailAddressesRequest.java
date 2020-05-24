package com.exebar.fetch_rewards.uniqueemailtest.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;

public class UniqueGmailAddressesRequest {

    private List<String> emailList;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        UniqueGmailAddressesRequest thatRequest = (UniqueGmailAddressesRequest) that;
        return Objects.equals(emailList, thatRequest.emailList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailList);
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
