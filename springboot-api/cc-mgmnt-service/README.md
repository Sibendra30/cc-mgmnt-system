*Author* : *Sibendra Pratap Singh ; spsingh23021991@gmail.com*

# Getting Started with Credit Card Management System APIs

This is a spring boot based maven project. It contains below APIs:

1. ***GET /cards***  - This API fetches all the cards available in system.
2. ***POST /cards***  - This API adds a new card info into system.

*Please refer api-spec.yaml for API documentation*

## Pre-requisite
1. Jdk 1.8+
2. Maven v3
3. Docker (optional)

## Run Application
mvn spring-boot:run

## Access APIs
http://localhost:8083

## Run Test
mvn clean test

***Also Dockerfile can be used to build and image and run the application on docker ***
