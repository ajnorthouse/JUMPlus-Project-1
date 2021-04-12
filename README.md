# JUMPlus-Project-1
Project 1 from the JUMPlus team. 
The project goal was to create a mock console application that a user could use to access a database (either external or in memory) to interact with their banking account. The main goals with this was to implement a MVC architecture, testing, and have the console print statements in color.

## Technologies used:
- Java
- Maven
- JUnit 5
- GitHub Actions

## Objectives:
1. Use layered architecture (abstracted files under SOLID principles) to make an MVC banking application.
1. Create a user login system (no DB necessary, use in program memory).
1. Once logged in, have a user menu display in console.
1. Allow user to:
    * Deposit
    * Withdrawal
    * Transfer Funds
    * View 5 most recent transactions
    * Display thier information
    * Sign out
1. Apply business logic to handle illegal operations in:
    * login system
    * Transactions (withdrawals / depsosits, etc.)
* BONUS 
    * use JDBC and DAO to connect user info to a database
