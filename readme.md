##  RESTful API webservice Cattery

### Table of contents
1. Introduction
2. Project 
3. Requirements
4. Installation guide
5. Users
6. Endpoints

### 1. Introduction

This backend programming final assignment was created as a result of the Backend Development course at NOVI University of Applied Sciences.

The project was set up with [Spring Boot](https://spring.io/projects/spring-boot). 

### 2. Project

For a cattery we create a system that keeps records of kittens, customers, items/prices and users.

An administrative employee or back office are authorized to add kittens and customers to the system. In addition to adding data, they can retrieve, delete and update data.

### 3. Requirements

- IntelliJ IDEA 2021.2
- Maven 3.6.3
- Java Development Kit 11.0.12
- PostgreSQL 13
- PgAdmin 5.4
- Postman 9.1.3

### 4. Installation guide

After installing all the tools on your Operating System, we can get started to run the Spring Boot application on your local machine.

* __Start up IDEA__
    * _Open the project_
        * clone the repository from [github](https://github.com/danielle076/cattery)
        * go to File > New > Project from Version Control
        * paste in the cloned URL
        * if git is not installed, choose download and install and proceed
        * click clone
        
    * _Set up Software Development Kit_
        * go to File > Project Structure
        * Project Settings > Project
            * Project SDK: select version 11
            * Project language level: choose SDK default 
            * click OK


* __Set up Database__
    * Start up Postgres and log in on PGAdmin with you master password
    * Open left tab `Servers`
        * Right mouse click on Login/Group Roles and choose `Create`
            * under tab general you fill in the name: `postgres`
            * under tab definition you fill in the password: `postgres123` and save
            * under tab privileges toggle `can login?` to yes.
        * Right mouse click on Databases and choose `Create` Database
            * under tab general you fill in the database: `cattery`
            * under tab general you fill in the owner: `postgres` and save

This way you can run the application from this cloned repository.

You can choose to change it and create a different database and login name and password as above described and change it in the [application.properties](src/main/resources/application.properties).

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cattery
spring.datasource.username=postgres
spring.datasource.password=postgres123
```

* __Set up info.java__

To retrieve the info from [Info.java](src/main/java/nl/danielle/cattery/model/Info.java), modify the link to where the cloned project is located. Modify only `/Users/intoy/Novi/Backend_end command/cattery/cattery/src/main/resources/`.

```jshelllanguage
private static final String FILENAMEUSER = "/Users/intoy/Novi/Backend_eindopdracht/cattery/cattery/src/main/resources/user.json";
private static final String FILENAMEBACKOFFICE = "/Users/intoy/Novi/Backend_eindopdracht/cattery/cattery/src/main/resources/backoffice.json";
```

* __Run the application__
    * Run with IDEA:
        * In your IDEA you open the tab `project`
        * cattery > src > main > java > [CatteryApplication](src/main/java/nl/danielle/cattery/CatteryApplication.java)
        * to run go to the green arrow next to public class: CatteryApplication on line 7
        * right mouse click and choose Run 'CatteryApplication' 
        * to check if your database is initialized and with the correct information corresponding with application.propperties the console will show you `Spring Data repositories initialized` 
    * Run with maven in command line: `$ mvn spring-boot:run`

### 5. Users

There are two hard coded users in [data.sql](src/main/resources/data.sql) that can be used when testing the endpoints in Postman.

|username|password| 
|----|----|
|user|$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica|
|backoffice|$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica|

### 6. Endpoints

In Postman you can test endpoints. You don't have to write these yourself, you can import a collection of my endpoints into Postman.

In the folder resources > [postman](src/main/resources/postman) there are 6 collections that you can save on your own computer. When you open Postman you will find two options above the collections: new and import. Choose import, select the 6 files and click import.

#### Pictures

In the folder resources > [pictures](src/main/resources/pictures), there are pictures that can be used for uploading pictures.

Instructions on how to add a photo in Postman:
- In _Body_ choose form-data
- Under _KEY_, enter `file` in lowercase and select _File_ (dropdown).
- Select the picture under _VALUE_ 

Instructions on how to download a photo in Postman:
- Go to https://localhost:8443/kittens/ with method GET
- At _fileUpload_ copy the id
- Put the id behind the url https://localhost:8443/kittens/download/
- When you have pressed send, go to _Save Response_, click on _Save to file_ and save the file as a _.jpg_ file