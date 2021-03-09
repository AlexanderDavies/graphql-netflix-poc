package com.au.alexanderdavies.graphqlnetflixpoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;
import com.au.alexanderdavies.graphqlnetflixpoc.entity.AccountEntity;
import com.au.alexanderdavies.graphqlnetflixpoc.entity.TransactionEntity;
import com.au.alexanderdavies.graphqlnetflixpoc.repository.AccountRepository;
import com.au.alexanderdavies.graphqlnetflixpoc.repository.TransactionRepository;
import com.au.alexanderdavies.graphqlnetflixpoc.service.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<TransactionDto> getTransactions(String accountId) {

        AccountEntity accountEntity = accountRepository.findByAccountId(accountId);

        List<TransactionEntity> transactions = transactionRepository.findAllByAccount(accountEntity);

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionDto> transactionList = new ArrayList<>();

        for (TransactionEntity transactionEntity : transactions) {
            TransactionDto transactionDto = modelMapper.map(transactionEntity, TransactionDto.class);

            transactionList.add(transactionDto);
        }

        return transactionList;
    }
}
