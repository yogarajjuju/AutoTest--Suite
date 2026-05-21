# AutoTest-Suite

A Selenium + TestNG web automation testing framework built with Java and Maven.

![CI](https://github.com/yogarajjuju/AutoTest--Suite/actions/workflows/test.yml/badge.svg)

## Tech Stack

- Java 11
- Selenium WebDriver 4.18
- TestNG 7.9
- WebDriverManager
- Maven
- GitHub Actions CI/CD

## Test Cases

| Test | Description | Status |
|------|-------------|--------|
| `testValidLogin` | Valid credentials redirect to inventory page | ✅ |
| `testInvalidLogin` | Invalid credentials show error message | ✅ |
| `testEmptyCredentials` | Empty fields show validation error | ✅ |

## Project Structure

AutoTest-Suite/
├── src/test/java/com/autotest/
│   ├── pages/
│   │   └── LoginPage.java        # Page Object Model
│   ├── tests/
│   │   └── LoginTest.java        # TestNG test cases
│   └── utils/
│       └── DriverManager.java    # WebDriver setup & teardown
├── .github/workflows/
│   └── test.yml                  # GitHub Actions CI/CD
├── testng.xml                    # TestNG suite config
└── pom.xml                       # Maven dependencies

## Run Tests Locally

Prerequisites: Java 11+, Maven, Google Chrome

git clone https://github.com/yogarajjuju/AutoTest--Suite.git
cd AutoTest--Suite/AutoTest-Suite
mvn test

## CI/CD

Tests automatically run on every push and pull request to main via GitHub Actions.

Every push triggers:
1. JDK 11 setup
2. Chrome installation
3. Full test suite execution via mvn test

## Design Pattern

This project uses the Page Object Model (POM) design pattern:
- Test logic is separated from page interaction logic
- Each page has its own class with locators and actions
- Tests are clean, readable, and maintainable