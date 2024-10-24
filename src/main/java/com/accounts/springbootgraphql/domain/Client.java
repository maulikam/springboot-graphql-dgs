package com.accounts.springbootgraphql.domain;

public record Client(String id, String accountId, String firstName, String middleName, String lastName) {
}
