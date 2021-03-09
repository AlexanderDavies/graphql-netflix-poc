package com.au.alexanderdavies.graphqlnetflixpoc.model.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseModel {
    private String transactionId;
    private long amount;
    private LocalDateTime date;
}
