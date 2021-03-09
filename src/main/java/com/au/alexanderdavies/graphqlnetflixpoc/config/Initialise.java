package com.au.alexanderdavies.graphqlnetflixpoc.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.au.alexanderdavies.graphqlnetflixpoc.SpringApplicationContext;
import com.au.alexanderdavies.graphqlnetflixpoc.dto.AccountDto;
import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;
import com.au.alexanderdavies.graphqlnetflixpoc.service.AccountService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialise implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <= 5; i++) {
            AccountService accountService = (AccountService) SpringApplicationContext.getBean("accountServiceImpl");

            List<TransactionDto> transactions = new ArrayList<>(
                    List.of(new TransactionDto(ThreadLocalRandom.current().nextInt(1, 1000 + 1), LocalDateTime.now()),
                            new TransactionDto(ThreadLocalRandom.current().nextInt(1, 1000 + 1), LocalDateTime.now()),
                            new TransactionDto(ThreadLocalRandom.current().nextInt(1, 1000 + 1), LocalDateTime.now())));

            AccountDto accountDetails = new AccountDto();

            accountDetails.setAccountName("Test Account 1 ");

            accountDetails.setBalance(ThreadLocalRandom.current().nextInt(1, 10000 + 1));

            accountDetails.setTransactions(transactions);

            accountService.createAccount(accountDetails);
        }
    }

}
