# Test assignment: Exchange rate server 

## Guidelines

This is a coding test assignment which will be used to assess your coding and software design skills.

* Unpack the zip file
* Implement requirements
* Pack the zip file and send it

If there were any challenging tasks during test assignment, please note down how you approached and resolved it.   

## Context

This project goal is to provide and API for currency exchange rates, (USD to UAH, EUR to USD, etc).
There is a file in resources\rates\data.json which contains exchange rates for our base currency - USD. For example, we know that 1 USD = 1.360006 CAD, 1 USD = 0.816306 EUR, and so on.  
Using this data, our exchange server can perform backward conversion.
* when CAD is base and USD is the target: 1 CAD is 0,735290 USD
* when EUR is base and USD is the target: 1 EUR is 1,225030 USD 

## Requirements for complete assignment

* Application should build successfully using `mvn clean install` command.
* Spring Application should start successfully using `mvn spring-boot:run` command.
* Application should provide a REST API which takes two parameters: base and target currency and produces a JSON response which is a currency rate between base and target. 
  Example: API receives "UAH" as base currency and "EUR" as target currency.
  This API should return a JSON that returns an exchange rate between UAH and EUR. This value should be calculated using initial data in `data.json`.     
* REST API should be implemented in com.intellias.exchangeserver.api.ExchangeRateApiController. Any other classes that you create should be placed in proper packages.
* API should do the calculation correctly when it is given any combination of base and target values if they are present in `data.json`
* API should handle exceptional situations when either base or target currency is not present in `data.json`. For example when base is YPY(not present in a file) and target is USD.
* API should meet REST API design standards.
* REST API controller should be covered by Spring tests. 
* Unit tests should be also implemented