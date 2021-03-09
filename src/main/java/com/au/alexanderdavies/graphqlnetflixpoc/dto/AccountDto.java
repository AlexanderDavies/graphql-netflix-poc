package com.au.alexanderdavies.graphqlnetflixpoc.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private long id;
    private String accountId; 
    private String accountName;
    private long balance;
    private List<TransactionDto> transactions;
}
