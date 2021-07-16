<br />
<p align="center">
<h1 align="center">Pricing</h1>



<!-- ABOUT THE PROJECT -->
### About The Project

The Service is responsible for randomly choosing a discount percentage to be applied to a certain price, however, the hour of the purchase will influence the discount percentage.

In this service, the consumer must inform the product's date/time of purchase and price.

Based on the time of purchase, the service/API will define, from a draw, a discount percentage to be applied to the value. The objective is to benefit purchases made earlier with the POSSIBILITY of obtaining a greater discount.
The maximum possible discount is 24%, however, for each lost hour, the chances are reduced by 1%.

Example: If the purchase was made at 00h, the discount can be from 0% to 24%
But if the purchase was made at 12 pm, the discount will be limited between 0 and 12%


## Summary

- [User Requirements](#user-requirements)
- [Assumptions](#assumptions)
- [Service - Price Calculate](#service---price-calculate)
- [Built With](#built-with)
- [Source Code](#source-code)
- [Usage](#usage)
    
### User Requirements

1) A service that calculates a price of something (the candidate can be creative, it can be a static
value, a random value, a base value plus the seconds fraction of current time).
   
### Assumptions

- Must be implemented in Java.
- Not focus on data storage. 
- Quality Assurance: Must implement unit test


## Service - Price Calculate

Example:
    
    Scenario 1: Purchase made at 00h: A percentage shall uo to 24%.
    Scenario 2: Purchase made at 12:00 pm: A percentage shall up to 12%
    Scenario 1: Purchase made at 11:00 pm: A percentage shall up to 1%


#### *API:*  (In localhost, use: Port:8082)
        
    POST:  /prices

        Content Type: application/json
        body:   
                {
                    "price": 100,
                    "dateTime": "2021-07-14T00:49:55"
                }

        response:
                {
                    "price": 100,
                    "priceWithDiscount": 80.0,
                    "description": "Purchase time: 0, Discount: 20%",
                    "dateTime": "2021-07-14T00:49:55.942056779"
                }    


## Class Diagram & Association

![alt text](https://github.com/FabricioEntringerMoreira/pricing/blob/main/docs/img/class-diagram-pricing.png)


## Built With

To implement the solution were used the below frameworks and tools were:

| Technology / Framework / Tool | Version | Motivation |
| --- | --- | --- |
| Java | 11 | A base requirement |
| Spring Boot | 2.5.2 | Spring boot was used to help us autoconfigure the application, we can use the built-in tomcat. |
| Spring WEB MVC | 2.5.2 | To user by easily way the MCV architecture built-in Spring Boot.  |
| Spring WEB MVC | 2.5.2 | To user by easily way the MCV architecture built-in Spring Boot.  |
| Lombook Framework | 1.18 | It was used to help us with data classes implementing some boilerplate code such as getters and setters methods and Data Builder Pattern. |
| JUnit + Mockito  | 4.12 | To work with unit tests and scenario simulation |


### Source Code

1. Backend
   ```sh
    git clone https://github.com/FabricioEntringerMoreira/pricing.git
   ```


## Usage

To test the consistency of the application's deployment and its external use, I made the application available in a free service for testing purposes.

POST Pricies: https://pricing-fem.herokuapp.com/prices


