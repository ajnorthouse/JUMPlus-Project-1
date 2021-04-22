# Basically a TODO Page




---
## v1.2 - Restructure
Refactor the Project to make for easier implementing of future plans

- [ ] Application
	- [ ] DollarsBankApplication
		- [ ] Just Main / Runner

- [ ] Controller
	- [ ] DollarsBankController
		- [ ] Menu Logic
		- [ ] Deposit
		- [ ] Withdraw
		- [ ] Transfer
	- [ ] UserController
		- [ ] Getters
		- [ ] Setters
		- [ ] Log Logic

- [x] Model
	- [x] User
		- [x] POJO

- [ ] Utility
	- [ ] ColorUtil
		- [ ] Same Thing it already does
	- [ ] ConsoleOutputUtil
		- [ ] This should handle all the console prints
	- [ ] InputParserUtil
		- [ ] Check Username
		- [ ] Check Password
		- [ ] Check String (generic)
		- [ ] Check Double
		- [ ] Check Int
	- [ ] RegexCheckerUtil
		- [ ] Check password
		- [ ] Check contact number
		- [ ] Check username

- [ ] View
	- [ ] UserView
		- [ ] Literally the Same
		- [ ] Log printer
	- [ ] DollarsBankView
		- [ ] Prints Menus
		- [ ] Prints Input requests?




---
## v1.3 - Testing
Implement more thorough testing.

### Testing:
	- [ ] User Model Testing
	- Don't test getters and setters UNLESS they have custom logic in them

- [ ] Controller
	- [ ] Bank Controller Testing
	- Remove unused methods
	- Create tests for the new methods

- [ ] Utility
	- [ ] ColorUtil
		- test various colors

- [ ] View
	- [ ] UserView
		- test user details string
		- test log string
	- [ ] DollarsBankView
		- test menu strings are correct




---
## v1.4 - Improvements
Usability improvements to make way for the next updates.

### Structures:
- [ ] For-Loops
  - change them to do-while loops with incrementer kept inside it.
  - so the incrementer can be kept track inside of it, allowing you to retry passwords, usernames, and the like on inputs in case they're invalid.


### User Interface:
- [ ] Ask user for dark-mode or light-mode on initial boot!
- [ ] Add a wait so people can read the results of screens.
  - https://stackoverflow.com/a/57567069




---
## v2.0 - DAO & Repo objects
Implement DAO and Repository objects to allow for easier SQL implementation.

### DAO
[ ] DaoInterface
	- [ ] Interface for specifying generic actions DAO should be able to perform
	- [ ] CREATE operations
	- [ ] READ operations
	- [ ] UPDATE operations
	- [ ] DELETE operations

[ ] DaoUserInterface implements DaoInterface
	- [ ] CRUD operations from DaoInterface
	- [ ] Other user specific actions

### Persistence
[ ] UserRepo
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




---
## v3 - Optional Features
### File saving
### Structures:
- [ ] Add a implementation that allows the user to chose between file saving and jdbc connection.


### Usability:
- [ ] Clear console?
  - \033[2J (ANSI character that clears the screen)
  - \033[H	(ANSI character that returns cursor to home)