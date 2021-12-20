# Reading excel file spring boot

The example shows how to load data from an excel file into the database 

## Loading data
The EmployeeUtils.java is responsible for loading the excel data into a List<Employee>

## Inserting into db
Then the data is logged in db using jpa

## Special dependencies

This make use of apache poi library below
````java
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.0.0</version>
</dependency>
````
