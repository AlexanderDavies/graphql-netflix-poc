# GraphQL Netflix poc (POC)
The intent of this **POC** is to demonstrate the use of GraphQL as a library to orchestrate and manage cross dependencies for the BFF layer as well as a federated GraphQL server.

## Run
mvn spring-boot:run -Dspring-boot.run.profiles=local

## H2 Dashboard
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)
username: sa
password: test1234

1. Run the following query select * from account;

2. Copy an account_id (GUID) to use in the steps below

## GraphQL Endpoint

[http://localhost:8080/graphiql](http://localhost:8080/graphiql)

1. Sign in with admin credentials: username: admin, password: test1235 (these can be changed in application.properties)

1. To test add the following queries into the left hand pane.

2. **!important**: ensure that you change the accountId to one selected/retrieved from the above H2 query

### REQUEST HEADERS 

```javascript
// IN REQUEST HEADERS TAB

{
  "Content-Type":"application/json", 
  "Authorization": "Basic YWRtaW46dGVzdDEyMzU="
}
```

### Get account
```javascript
 // IN QUERY

  {
      account(accountId: "hvQ3b0uom9H6LdgO90Q12345asdfg") {
          accountId
          accountName
          balance
      }
  }
```


### Get Account and Transactions
```javascript
  // IN QUERY EDITOR
  
  query($accountId:String!)
  {
    account(accountId:$accountId) 
    {
        accountId
        accountName
        balance
    }
    transaction(accountId:$accountId)
    {
        transactionId
        amount
        date
    }
  }
```
```javascript
  // IN QUERY VARIABLES EDITOR

  {  
    "accountId": "hvQ3b0uom9H6LdgO90Q12345asdfg"
  }

```

## BFF AccountDetails endpoint
[http://localhost:8080/account-details](http://localhost:8080/account-details)

The postman collection is located in resources/graphql-netflix-poc.postman_collection

**!IMPORTANT:** ensure that you change the accountId path variable to one selected from H2 dashboard i.e. http://localhost:8080/account-detail/ZRM5aGuzyEjHRZKzr2QiE5cTapMSwd