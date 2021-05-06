# Basically a TODO Page




---
## v1.4 - Improvements
Usability improvements to make way for the next updates.

### Structures:
- [ ] For-Loops
  - change them to do-while loops with incrementer kept inside it.
  - so the incrementer can be kept track inside of it, allowing you to retry passwords, usernames, and the like on inputs in case they're invalid.

### Update Data:
- [ ] Allow users to update info on themselves
  - As in: their name, contact number, username, password, etc.


### User Interface:
- [ ] Ask user for dark-mode or light-mode on initial boot!
- [ ] Add a wait so people can read the results of screens.
  - https://stackoverflow.com/a/57567069




---
## v2.0 - DAO & Repo objects
Implement DAO and Repository objects to allow for easier SQL implementation.

### DAO
- [ ] DaoInterface
	- [ ] Interface for specifying generic actions DAO should be able to perform
	- [ ] CREATE operations
	- [ ] READ operations
	- [ ] UPDATE operations
	- [ ] DELETE operations

- [ ] DaoUserInterface implements DaoInterface
	- [ ] CRUD operations from DaoInterface
	- [ ] Other user specific actions

### Persistence
- [ ] UserRepo
	- [ ] Collection of the User Objects
	- should support:
		- [ ] .add()
		- [ ] .get()
		- [ ] .set()
		- [ ] .remove()
		- [ ] .size()
	- calls Dao of current persistence system through DaoInterface

### Testing
- [ ] DAO
	- [ ] DaoInterface
		- [ ] Interface for specifying generic actions DAO should be able to perform
		- [ ] CREATE operations
		- [ ] READ operations
		- [ ] UPDATE operations
		- [ ] DELETE operations

	- [ ] DaoUserInterface implements DaoInterface
		- [ ] CRUD operations from DaoInterface
		- [ ] Other user specific actions

- [ ] Persistence
	- [ ] UserRepo
		- [ ] Collection of the User Objects
		- should support:
			- [ ] .add()
			- [ ] .get()
			- [ ] .set()
			- [ ] .remove()
			- [ ] .size()
		- calls Dao of current persistence system through DaoInterface



---
## v2.1 - SQL
Implement the SQL connection and its objects.

### SQL
- [ ] Persistence
	- [ ] UserRepo
		- have it call the DAO interface to manage data
- [ ] SQL
	- [ ] SqlConnectionManager
		- Singleton design
		- Use JDBC
		- Only concerned with connecting
	- [ ] DaoUserSql
		- specifically only for the SQL commands
		- reading the resultsets from the sql connection
		- transform sql resultsets into objects

### Testing
- [ ] Persistence
	- [ ] UserRepo
		- new methods
- [ ] SQL
	- [ ] SqlConnectionManager
		- I'm not sure, honestly
	- [ ] DaoUserSql
		- super also not sure




---
## v3 - Accounts
Implement Accounts

### Accounts
- [ ] View
	- [ ] AccountView
		- Prints out the account details
		- Takes account object
- [ ] Controller
	- [ ] AccountController
		- logic for getters and setters
		- logic for log
		- calls AcountController
		- calls UserRepo
- [ ] DAO
	- [ ] DaoAccountInterface implements DaoInterface
		- CRUD operations from DaoInterface
		- Other account specific actions
- [ ] Model
	- [ ] Account
		- constructor
		- getters
		- setters
- [ ] Persistence
	- [ ] AccountRepo
		- Collection of the Account Objects
		- should support:
			- .add()
			- .get()
			- .set()
			- .remove()
			- .size()
		- calls Dao of current persistence system through DaoInterface
- [ ] SQL
	- [ ] DaoAccountSql implements DaoAccountInterface
		- specifically only for the SQL commands
		- reading the resultsets from the sql connection
		- transform sql resultsets into objects
- [ ] View
	- [ ] AccountView
		- Prints out the account details
		- Takes account object
### App Implementation
- [ ] Menus
	- [ ] Extra Submenu for accounts
	- [ ] Accessed via pin
- [ ] Users
	- [ ] have to have account connections
- [ ] DB
	- [ ] many to many table with users
- Joint Accounts?




---
## v4
File implementation

### File
- [ ] FileManager
	- Singleton design
	- encodes
	- decodes
	- only concerned with saving & reading
- [ ] UserFileDao implements DaoUserInterface
	- specifically only for the file processes
	- serialize users
	- deserialize users into objects
- [ ] AccountFileDao implements DaoUserInterface
	- specifically only for the file processes
	- serialize accounts
	- deserialize accounts into objects
### Structures:
- [ ] Add a implementation that allows the user to chose between file saving and jdbc connection.


### Usability:
- [ ] Clear console?
  - \033[2J (ANSI character that clears the screen)
  - \033[H	(ANSI character that returns cursor to home)
