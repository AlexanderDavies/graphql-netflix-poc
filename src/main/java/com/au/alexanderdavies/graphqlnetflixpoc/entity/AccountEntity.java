package com.au.alexanderdavies.graphqlnetflixpoc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="account")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 6809850918765383696L;
       
    @Id
    @GeneratedValue
    private long id;
    
    @Column(length=30, nullable = false)
    private String accountId;
    
    @Column(length=50, nullable = false)
    private String accountName; 

    @Column(nullable = false)
    private long balance;

    @OneToMany(mappedBy="account", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }


}
