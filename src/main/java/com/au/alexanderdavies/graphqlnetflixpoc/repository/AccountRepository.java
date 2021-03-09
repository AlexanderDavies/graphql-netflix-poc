package com.au.alexanderdavies.graphqlnetflixpoc.repository;

import com.au.alexanderdavies.graphqlnetflixpoc.entity.AccountEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    public AccountEntity findByAccountId(String accountId);
}
