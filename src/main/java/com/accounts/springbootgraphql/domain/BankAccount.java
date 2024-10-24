package com.accounts.springbootgraphql.domain;

public record BankAccount(String id, String clientId, Currency currency, float balance, String status) { }
