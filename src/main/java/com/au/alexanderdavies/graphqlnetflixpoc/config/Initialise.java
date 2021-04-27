package com.au.alexanderdavies.graphqlnetflixpoc.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.au.alexanderdavies.graphqlnetflixpoc.SpringApplicationContext;
import com.au.alexanderdavies.graphqlnetflixpoc.dto.AccountDto;
import com.au.alexanderdavies.graphqlnetflixpoc.dto.TransactionDto;
import com.au.alexanderdavies.graphqlnetflixpoc.service.AccountService;
import com.au.alexanderdavies.graphqlnetflixpoc.service.TransactionService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialise implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {

                String[] accountIds = { "hvQ3b0uom9H6LdgO90Q12345asdfg", "CJfjGezjJl26pCc84yM812345asdfg",
                                "pHbJBXxMVjHWSyZQLE1J12345asdfg", "L07Mo4I6V59RF4A76s5w12345asdfg",
                                "eugsM0sALcIaGQ9ALSvG12345asdfg", "1ibhMhD8GbG4thDbXJVv12345asdfg" };

                for (int i = 0; i <= 5; i++) {
                        AccountService accountService = (AccountService) SpringApplicationContext
                                        .getBean("accountServiceImpl");
                        TransactionService transactionService = (TransactionService) SpringApplicationContext
                                        .getBean("transactionServiceImpl");

                        List<TransactionDto> transactions = new ArrayList<>(List.of(new TransactionDto(accountIds[i],
                                        ThreadLocalRandom.current().nextInt(1, 1000 + 1), LocalDateTime.now()),
                                        new TransactionDto(accountIds[i],
                                                        ThreadLocalRandom.current().nextInt(1, 1000 + 1),
                                                        LocalDateTime.now()),
                                        new TransactionDto(accountIds[i],
                                                        ThreadLocalRandom.current().nextInt(1, 1000 + 1),
                                                        LocalDateTime.now())));

                        transactions.forEach(transaction -> {
                                transactionService.createTransaction(transaction);
                        });

                        AccountDto accountDetails = new AccountDto();

                        accountDetails.setAccountName("Test Account 1 ");

                        accountDetails.setBalance(ThreadLocalRandom.current().nextInt(1, 10000 + 1));

                        accountDetails.setAccountId(accountIds[i]);

                        accountService.createAccount(accountDetails);
                }
        }

}
