package com.au.alexanderdavies.graphqlnetflixpoc.datafetcher;

import java.util.ArrayList;
import java.util.List;

import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;
import com.au.alexanderdavies.graphqlnetflixpoc.model.response.TransactionResponseModel;
import com.au.alexanderdavies.graphqlnetflixpoc.service.TransactionService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class TranscationDataFetcher {
    
    @Autowired
    TransactionService transactionService;

    @DgsData(parentType = "Query", field = "transaction")
    public List<TransactionResponseModel> transaction(@InputArgument("accountId") String accountId) {
        List<TransactionDto> transactions = transactionService.getTransactions(accountId);

        ModelMapper modelMapper = new ModelMapper();

        List<TransactionResponseModel> transactionResponse = new ArrayList<>();

        for (TransactionDto transaction : transactions) {
            TransactionResponseModel txRes = modelMapper.map(transaction, TransactionResponseModel.class);

            transactionResponse.add(txRes);
        }

        return transactionResponse;
    }
}
