package com.au.alexanderdavies.graphqlnetflixpoc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "transaction")
public class TransactionEntity implements Serializable {

    private static final long serialVersionUID = -5101483259846340679L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 30, nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 30, nullable = false)
    private String accountId;

}
