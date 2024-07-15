# Parabank Automation

Welcome to the Parabank Automation project! This repository contains automated tests for key functionalities of the Parabank web application using Selenium Java and TestNG.

## Project Overview

This project aims to automate various functionalities of Parabank, ParaBank is a demo site used for demonstration of Parasoft software solutions. All materials herein are used solely for simulating a realistic online banking website.

In other words: ParaBank is not a real bank!

Demo https://parabank.parasoft.com/parabank/index.htm

## Key Features

1. **Handling Dynamic Content**
    - Overcomes challenges with dynamic web elements and data to ensure smooth test execution.

2. **Data-Driven Testing**
    - Implements data-driven techniques to parameterize tests, enhancing efficiency and reusability.

3. **Reporting and Logging**
    - Integrates TestNG for comprehensive reporting, enabling detailed analysis of test results and issue identification.

4. **Cross-Browser Testing**
    - Ensures compatibility across multiple browsers for comprehensive test coverage.

## Covered Test Cases

- Automate User Registration process
- Automate successful user login
- Automate User Log Out functionality
- Automate Account Opening process
- Automate Funds Transfer functionality
- Automate Account Overview page navigation

## Registration Test Data

This repository includes test data for registration testing using data-driven techniques.

### File Details
- **File Name**: DataRegister.csv
- **Purpose**: Contains registration data for automated tests.
- **Important Note**: Before running the registration test suite, ensure that the username field in `DataRegister.csv` is unique. Update it accordingly to avoid conflicts during test execution.

### Data Format
Each line in `DataRegister.csv` follows the format:
Salim, Souidi, Tunisia, Kasserine, Zalfen, 12345, 12345678, 123, test08, 123456


### Field Descriptions
1. First Name
2. Last Name
3. Country
4. City
5. Address
6. Zip Code
7. Phone Number
8. SSN
9. Username
10. Password


## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Selenium WebDriver
- TestNG

### Installation and Running Tests

1. Clone the repository:
    ```sh
    git clone https://github.com/salimessouidi7/ParabankAutomation.git
    ```
2. Navigate to the project directory:
    ```sh
    cd ParabankAutomation
    ```
3. Install dependencies:
    ```sh
    mvn install
    ```
4. To run the tests, execute the following command:
    ```sh
    mvn test
    ```

### Reporting

The Extent Reports generated from the Selenium TestNG tests are located under target/extent-report.html.

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.
