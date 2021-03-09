package com.au.alexanderdavies.graphqlnetflixpoc.service;

import java.util.List;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;

public interface TransactionService {
    public List<TransactionDto> getTransactions(String accountId);
}
