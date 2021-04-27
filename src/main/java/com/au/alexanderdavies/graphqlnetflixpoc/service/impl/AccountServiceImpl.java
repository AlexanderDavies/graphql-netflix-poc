package com.au.alexanderdavies.graphqlnetflixpoc.service.impl;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.AccountDto;
import com.au.alexanderdavies.graphqlnetflixpoc.entity.AccountEntity;
import com.au.alexanderdavies.graphqlnetflixpoc.repository.AccountRepository;
import com.au.alexanderdavies.graphqlnetflixpoc.service.AccountService;
import com.au.alexanderdavies.graphqlnetflixpoc.util.GenerateId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GenerateId generateId;

    @Override
    public AccountDto createAccount(AccountDto account) {

        ModelMapper modelMapper = new ModelMapper();

        AccountEntity accountEntity = modelMapper.map(account, AccountEntity.class);

        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);

        return modelMapper.map(savedAccountEntity, AccountDto.class);
    }


    @Override
    public AccountDto getAccount(String accountId) throws RuntimeException {
        AccountEntity accountEntity = accountRepository.findByAccountId(accountId);

        if(accountEntity == null) {
            throw new RuntimeException("account not found");
        }
        
        ModelMapper modelMapper = new ModelMapper();
        
        return modelMapper.map(accountEntity, AccountDto.class);
    }
}
