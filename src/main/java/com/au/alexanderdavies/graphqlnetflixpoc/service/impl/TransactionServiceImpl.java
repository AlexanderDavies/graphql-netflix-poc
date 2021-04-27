package com.au.alexanderdavies.graphqlnetflixpoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;
import com.au.alexanderdavies.graphqlnetflixpoc.entity.TransactionEntity;
import com.au.alexanderdavies.graphqlnetflixpoc.repository.TransactionRepository;
import com.au.alexanderdavies.graphqlnetflixpoc.service.TransactionService;
import com.au.alexanderdavies.graphqlnetflixpoc.util.GenerateId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    GenerateId generateId;

    @Override
    public List<TransactionDto> getTransactions(String accountId) {

        List<TransactionEntity> transactions = transactionRepository.findAllByAccountId(accountId);

        if (transactions == null || transactions.isEmpty()) {
            return new ArrayList<>();
        }

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionDto> transactionList = new ArrayList<>();

        for (TransactionEntity transactionEntity : transactions) {
            TransactionDto transactionDto = modelMapper.map(transactionEntity, TransactionDto.class);

            transactionList.add(transactionDto);
        }

        return transactionList;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transaction) {
        ModelMapper modelMapper = new ModelMapper();

        TransactionEntity transasctionEntity = modelMapper.map(transaction, TransactionEntity.class);

        transasctionEntity.setTransactionId(generateId.generateTransactionId(30));

        TransactionEntity savedTransaction = transactionRepository.save(transasctionEntity);
        
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }
}
