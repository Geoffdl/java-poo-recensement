## User Input validation

- Added user input validation with throwable exception ScannerInputException
- It is collected at the lowest level with UserInputValidator.java
- then thrown throughout the service methods and finaly collected within the Main app inside a try-catch
