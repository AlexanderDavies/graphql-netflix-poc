package com.au.alexanderdavies.graphqlnetflixpoc.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseModel {
    private String accountId;
    private String accountName;
    private long balance;
}
