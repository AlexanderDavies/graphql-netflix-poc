package com.au.alexanderdavies.graphqlnetflixpoc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "account")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 6809850918765383696L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 30, nullable = false)
    private String accountId;

    @Column(length = 50, nullable = false)
    private String accountName;

    @Column(nullable = false)
    private long balance;

}
