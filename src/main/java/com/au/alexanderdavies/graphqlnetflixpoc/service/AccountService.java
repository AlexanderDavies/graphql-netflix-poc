package com.au.alexanderdavies.graphqlnetflixpoc.service;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.AccountDto;


public interface AccountService {
    public AccountDto getAccount(String id);
    public AccountDto createAccount(AccountDto accountDto);
}
