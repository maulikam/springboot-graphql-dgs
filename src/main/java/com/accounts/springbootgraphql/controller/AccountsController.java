package com.accounts.springbootgraphql.controller;

import com.accounts.springbootgraphql.domain.BankAccount;
import com.accounts.springbootgraphql.domain.Client;
import com.accounts.springbootgraphql.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AccountsController {
    @Autowired
    BankService bankService;

    @QueryMapping
    List<BankAccount> accounts () {
        log.info("Getting Accounts");
        return bankService.getAccounts();
    }

    @BatchMapping(field = "client")
    Map<BankAccount, Client> getClient(List<BankAccount> accounts) {
        log.info("Gettings clients for Accounts: " + accounts.size());
        return bankService.getClients(accounts);
    }
}
