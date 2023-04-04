# My Bank

## Introduction
.

## Operations available
The application exposes several operations via its REST API:
* Register user
* Create wallet
* Deposit money into a wallet
* Get wallet with its movements
* Transfer between 2 wallets

## TODO / Things to Improve
Although the application is functional, there are some areas that could be improved:
* Currently, there are only unit tests for the register user use case and a couple of integration tests. More tests are needed for the rest of the use cases.
* More validation could be added to ensure data integrity.
* Additionally, the implementation of the transfer use case is not yet complete.

## How to Run the Application
To run the application, simply execute the following command from the boot module:

```
mvn spring-boot:run
```

This will start the application and allow you to interact with it using the different endpoints.
The OpenApi definition can be accessed here:
http://localhost:8080/mybank/swagger-ui.html



