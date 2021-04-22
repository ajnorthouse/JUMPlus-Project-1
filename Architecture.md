# Architecture Ideas:
These are ideas I've got on the architecture, and a place I can keep track of the current architecture too.

---
## v2 Architecture Plans
### Application
DollarsBankApplication
	- main / runner
	- any objects needed to be instantiated at start


### Controller
DollarsBankController
	- logic for menus
	- calls other controllers

UserController
	- logic for getters and setters
	- logic for log
	- calls AcountController
	- calls UserRepo


### DAO
DaoInterface
	- Interface for specifying generic actions DAO should be able to perform
	- CREATE operations
	- READ operations
	- UPDATE operations
	- DELETE operations

DaoUserInterface implements DaoInterface
	- CRUD operations from DaoInterface
	- Other user specific actions


### Model
User
	- constructor
	- getters
	- setters


### Persistence
UserRepo
	- Collection of the User Objects
	- should support:
		- .add()
		- .get()
		- .set()
		- .remove()
		- .size()
	- calls Dao of current persistence system through DaoInterface


### SQL
SqlConnectionManager
	- Singleton design
	- Use JDBC
	- Only concerned with connecting

DaoUserSql implements DaoUserInterface
	- specifically only for the SQL commands
	- reading the resultsets from the sql connection
	- transform sql resultsets into objects

DaoAccountSql implements DaoAccountInterface
	- specifically only for the SQL commands
	- reading the resultsets from the sql connection
	- transform sql resultsets into objects


### Utility
ColorsUtility
	- Just adds ANSI colors to the print statements

ConsolePrinterUtility
	- Just prints to the console

InputParserUtility
	- Cleans and parses input

RegexCheckerUtility
	- Checks Regex


### View
DollarsBankView
	- Prints out the Menus

AccountView
	- Prints out the account details
	- Takes account object

UserView
	- Prints out the user details
	- takes user object

---

## Final Architecture Plans
### Application
DollarsBankApplication
	- main / runner
	- any objects needed to be instantiated at start


### Controller
DollarsBankController
	- logic for menus
	- calls other controllers

UserController
	- logic for getters and setters
	- logic for log
	- calls AcountController
	- calls UserRepo

AccountController
	- logic for getters and setters
	- logic for log
	- calls AcountController
	- calls UserRepo


### DAO
DaoInterface
	- Interface for specifying generic actions DAO should be able to perform
	- CREATE operations
	- READ operations
	- UPDATE operations
	- DELETE operations

DaoUserInterface implements DaoInterface
	- CRUD operations from DaoInterface
	- Other user specific actions

DaoAccountInterface implements DaoInterface
	- CRUD operations from DaoInterface
	- Other account specific actions


### File
FileManager
	- Singleton design
	- encodes
	- decodes
	- only concerned with saving & reading

UserFileDao implements DaoUserInterface
	- specifically only for the file processes
	- serialize users
	- deserialize users into objects

AccountFileDao implements DaoUserInterface
	- specifically only for the file processes
	- serialize accounts
	- deserialize accounts into objects


### Model
User
	- constructor
	- getters
	- setters

Account
	- constructor
	- getters
	- setters


### Persistence
UserRepo
	- Collection of the User Objects
	- should support:
		- .add()
		- .get()
		- .set()
		- .remove()
		- .size()
	- calls Dao of current persistence system through DaoInterface

AccountRepo
	- Collection of the Account Objects
	- should support:
		- .add()
		- .get()
		- .set()
		- .remove()
		- .size()
	- calls Dao of current persistence system through DaoInterface


### SQL
SqlConnectionManager
	- Singleton design
	- Use JDBC
	- Only concerned with connecting

DaoUserSql implements DaoUserInterface
	- specifically only for the SQL commands
	- reading the resultsets from the sql connection
	- transform sql resultsets into objects

DaoAccountSql implements DaoAccountInterface
	- specifically only for the SQL commands
	- reading the resultsets from the sql connection
	- transform sql resultsets into objects


### Utility
ColorsUtility
	- Just adds ANSI colors to the print statements

ConsolePrinterUtility
	- Just prints to the console

InputParserUtility
	- Cleans and parses input

RegexCheckerUtility
	- Checks Regex


### View
DollarsBankView
	- Prints out the Menus

AccountView
	- Prints out the account details
	- Takes account object

UserView
	- Prints out the user details
	- takes user object