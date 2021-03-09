package com.au.alexanderdavies.graphqlnetflixpoc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {
    private long id;
    private String transactionId;
    private long amount;
    private LocalDateTime date;
    private AccountDto account;

    public TransactionDto(long amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

}
