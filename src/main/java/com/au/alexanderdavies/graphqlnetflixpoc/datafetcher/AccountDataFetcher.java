package com.au.alexanderdavies.graphqlnetflixpoc.datafetcher;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.AccountDto;
import com.au.alexanderdavies.graphqlnetflixpoc.model.response.AccountResponseModel;
import com.au.alexanderdavies.graphqlnetflixpoc.service.AccountService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class AccountDataFetcher {

    @Autowired
    AccountService accountService;

    @DgsData(parentType = "Query", field = "account")
    public AccountResponseModel account(@InputArgument("accountId") String accountId) {
        AccountDto account = accountService.getAccount(accountId);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(account, AccountResponseModel.class);

    }
}
