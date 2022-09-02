# Project Virtual Power Plant

This  project is  for  java developer interview coding assignment 

## Getting Started

clone the project using " https://github.com/rohit153/Virtual-Power-plant.git  "

### Prerequisites

```
java  version=    1.8
IDE = any of your favorite  and maven 
```



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
## Data Base 
in-memory data database is use in this project  .ie h2 database
 dependecy
  ````
       <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.193</version>
        </dependency>
   ````

## Swagger documentation

Synchronizes the API documentation with the server and client at the same pace.
Allows us to generate REST API documentation and interact with the REST API
Provides responses in the format of JSON .

*API = http://localhost:8080/swagger-ui.html

````
      <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
````
## Test Class 

Test class in under the  package of test class name is ApplicationTests


## save List of Batteries Rest Api  


*  localhost:8080/api/v1/save" - save the batteries list 
* RequestBody for saving batteries
 ````
[
    {
        "name": "Cannington",
        "postcode": "6107",
        "capacity": 13500
    },
    {
        "name": "Midland",
        "postcode": "6057",
        "capacity": 50500
    }
]
 ````
* validation is only for null values
 ````
[
    {
        "name": null,
        "postcode": "6107",
        "capacity": 13500
    },
    {
        "name": "Midland",
        "postcode": "6057",
        "capacity": 50500
    }
]
 ````

* Response as
````````
{
    "status": "FAIL",
    "httpCode": 400,
    "dateTime": "2022-08-26T18:25:47.455+00:00",
    "message": "NAME field should not be null",
    "errors": [
        "NAME field should not be null"
    ]
}
````````


## find batteries  by giving two PostCodeRange 
*RestApi for searching - localhost:8080/api/v1/get-batteries
*RequestBody
```````` 
{
    "firstRangeParameter":6056,
    "lastRangeParameter":6057
}
```````` 

* Response Body
````
{
    "status": "SUCCESS",
    "message": "batteries fetch successfully",
    "dateTime": "2022-08-26T17:57:30.059+00:00",
    "data": {
        "totalWattCapacity": 101000.0,
        "averageWattCapacity": 50500.0,
        "batteryPojos": [
            {
                "name": "Midland",
                "postcode": "6057",
                "capacity": 50500,
                "id": 2
            },
            {
                "name": "Midland",
                "postcode": "6057",
                "capacity": 50500,
                "id": 22
            }
        ]
    }
}
````


## Authors

* **Rohit Tamang** - *Initial work*

