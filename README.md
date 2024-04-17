# Sample Banking Application with Spring Boot

Practice session with Spring Boot focusing on CRUD operations in a sample banking application. Implemented REST API endpoints for adding accounts, retrieving account details, depositing and withdrawing money, viewing all accounts, and deleting accounts.


This project is a practice session focusing on CRUD operations in a sample banking application using Spring Boot. Below are the REST API endpoints and their usage:

### 1. Add Account
- Endpoint: `POST localhost:8080/api/accounts`
- Request Body:
  ```json
  {
      "accountHolderName": "Md. Al-Amin",
      "balance": 4600.0
  }
  ```

### 2. Get Account by ID
- Endpoint: `GET localhost:8080/api/accounts/{id}`
- RESULT:
  ```json
  {
    "id": 2,
    "accountHolderName": "Md. Al-Amin",
    "balance": 4600.0
  }
  ```

### 3. Get All Accounts
- Endpoint: `GET localhost:8080/api/accounts`
- RESULT:
  ```json
  [
    {
        "id": 2,
        "accountHolderName": "Md. Al-Amin",
        "balance": 4600.0
    }
  ]
  ```

### 4. Delete Account
- Endpoint: `DELETE localhost:8080/api/accounts/{id}`
- RESULT:
  ```json
  Account delete successfully.
  ```

### 5. Deposit
- Endpoint: `PUT localhost:8080/api/accounts/{id}/deposit`
- Request Body:
  ```json
  {
      "amount": 15
  }
  ```
- RESULT:
  ```json
  {
    "id": 2,
    "accountHolderName": "Md. Al-Amin",
    "balance": 4615.0
  }
  ```

### 6. Withdraw
- Endpoint: `PUT localhost:8080/api/accounts/{id}/withdraw`
- Request Body:
  ```json
  {
      "amount": 84
  }
  ```
- RESULT:
  ```json
  {
    "id": 2,
    "accountHolderName": "Md. Al-Amin",
    "balance": 4531.0
  }
  ```

Feel free to explore and test these API endpoints for hands-on practice with Spring Boot.
