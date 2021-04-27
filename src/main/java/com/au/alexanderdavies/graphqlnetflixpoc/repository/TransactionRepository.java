package com.au.alexanderdavies.graphqlnetflixpoc.repository;

import java.util.List;

import com.au.alexanderdavies.graphqlnetflixpoc.entity.TransactionEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
    public List<TransactionEntity>findAllByAccountId(String accountId);   
}
