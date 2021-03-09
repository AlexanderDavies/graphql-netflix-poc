package com.au.alexanderdavies.graphqlnetflixpoc.controller;

import com.netflix.graphql.dgs.DgsQueryExecutor;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("account-detail")
public class AccountDetailController {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Object getAccountDetails(@PathVariable String id) {

        String queryString = "{account(accountId: \"" + id + "\") {accountId accountName balance}"
                + " transaction(accountId: \"" + id + "\") {transactionId amount date}}";


        // !IMPORTANT need to add in security measures to prevent injection attack
        return dgsQueryExecutor.executeAndExtractJsonPath(queryString, "data");

    }

}