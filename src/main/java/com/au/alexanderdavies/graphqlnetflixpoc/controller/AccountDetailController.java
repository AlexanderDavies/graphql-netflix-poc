package com.au.alexanderdavies.graphqlnetflixpoc.controller;

import java.util.Collections;

import com.au.alexanderdavies.graphqlnetflixpoc.util.GraphQlQuery;
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

        String queryString = GraphQlQuery.GET_ACCOUNT_DETAILS.fetchQuery();

        return dgsQueryExecutor.executeAndExtractJsonPath(queryString, "data", Collections.singletonMap("accountId", id));

    }

}