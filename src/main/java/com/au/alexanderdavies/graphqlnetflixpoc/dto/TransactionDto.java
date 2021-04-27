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
    private String accountId;
    private long amount;
    private LocalDateTime date;

    public TransactionDto(String accountId, long amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
    }

}
