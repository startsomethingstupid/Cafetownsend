# CafeTownsend Automated Testing

This project is developed for automated testing of the web site - http://cafetownsend-angular-rails.herokuapp.com/

## Test Approach

The project is developed using Java and Selenium Automation Framework. TestNG is used as the testing framework.
Page Object Model (POM) design pattern is used to separate the WebElements, Page Methods and the Test execution.

Following test cases have been executed

| Sr No  | Test Case Description |Result|
| ------ | ------------- |--------------|
| 1| Invalid Login - Incorrect Uusername, Correct Password|Passed|
| 2| Invalid Login - Correct Username, Incorrect Password|Passed|
| 3| Invalid Login - Correct Username, Blank Password|Passed|
| 4| Invalid Login - Blank Username, Correct Password|Passed|
| 5| Valid Login|Passed|
| 6| Invalid Create Employee - Invalid Last Name|Passed|
| 7| Invalid Create Employee - Invalid First Name|Passed|
| 8| Invalid Create Employee - Invalid Start Date|Passed|
| 9| Invalid Create Employee - Invalid Email|Passed|
| 10| Create Employee|Passed|
| 11| Update Employee|Passed|
| 12| Delete Employee|Passed|
| 13| Logout|Passed|


## Pre-requisites

__Step 1: Install Maven 3.0.3+__

[Download from here](http://maven.apache.org/download.html)

__Step 2: Ensure maven binaries are on your PATH (ie. you can run `mvn` from anywhere)__

Follow the installation instructions from [here](http://maven.apache.org/download.html#Installation).


Running Tests
-----
Run the following command in the root folder
```
mvn test
``` 