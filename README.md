# ShoppingServer
# Description
This is a Shopping backend server. It provides management portal for manager to do their job faster and easier. A manager can add new member, check product details of status, edit and add new products.

This application was created using: Java 8, JDBC, Servlets, Tomcat 8.5, PostgreSQL, JUnit, Maven...

# API description
    -endpoints
    -description
    -example input/output

# DOMO
## Login (doGET Method)

Type in username and password in parameters field and follow by your email and password.
If you login successfully, it will return your role. Otherwise, you will be recognized as Guest.

Input:
>http:3.135.225.25:8080/Project0/Login?username=admin2@gmail.com&password=1234

Output:
```json
[
    "Manager"
]
```
## Change Password (doPOST method)

Input:

>http://3.135.225.25:8080/Project0/ChangePassword?email=customerA@gmail.com&password=999

Output:
```json
User email: customerA@gmail.com change password successfully.
```
##ShowAllUsers (doGET Method)
Input:
>http://3.135.225.25:8080/Project0/ShowAllUsers

Output:
```json
[
    {
        "id": 1,
        "email": "admin2@gmail.com",
        "password": "1234",
        "role": "Manager"
    },
    {
        "id": 4,
        "email": "customerC@gmail.com",
        "password": "999",
        "role": "Customer"
    },
    {
        "id": 6,
        "email": "customerD@gmail.com",
        "password": "9876",
        "role": "Customer"
    }
]
```

## AddNewUser (doPOST Method)

Input:
>http://3.135.225.25:8080/Project0/AddUser

Body:
```json
{
    "email":"customerGG@gmail.com",
    "password":"999",
    "role":"Customer"
}
```
Output:
```json
{
    "id": 8,
    "email": "customerGG@gmail.com",
    "password": "999",
    "role": "Customer"
}
```
## DeleteUser (doGET Method)
Input:
>http://3.135.225.25:8080/Project0/DeleteUser?id=8

Output:
```json
User id: 8 has been deleted successfully.
```


## If your role is manager, you can run
displayAllProductWithStatus

Input:
>http://3.135.225.25:8080/Project0/displayAllProductWithStatus?Role=Manager

Output:
```json
[
    {
        "id": 1,
        "name": "Table",
        "status": {
            "id": 1,
            "status": "Shipped"
        }
    },
    {
        "id": 2,
        "name": "Chair",
        "status": {
            "id": 2,
            "status": "Coming soon"
        }
    },
    {
        "id": 3,
        "name": "Printer",
        "status": {
            "id": 3,
            "status": "Not Shipped"
        }
    },
    {
        "id": 4,
        "name": "Caps",
        "status": {
            "id": 3,
            "status": "Not Shipped"
        }
    },
    {
        "id": 5,
        "name": "Knife",
        "status": {
            "id": 1,
            "status": "Shipped"
        }
    }
]
```
## Add a new product (doPOST Method)

Input: 
>http://3.135.225.25:8080/Project0/displayAllProductWithStatus

Product Body
```json
{
    "name":"cat",
    "status":"Shipped"
}
```

Output:
```json
{
    "id": 6,
    "name": "cat",
    "status": {
        "id": 1,
        "status": "Shipped"
    }
}
```

## GET /FindOrderById
Search a product by ID from database
See example output below

Input:
>http://3.135.225.25:8080/Project0/FindOrderById?id=2

Output:
```json
[
    {
        "id": 2,
        "name": "Chair",
        "status": {
            "id": 2,
            "status": "Coming soon"
        }
    }
]
```

# How to Startup the Application
## Prerequisites
You will have to download the following in order to set up the app locally:
- maven
- tomcat
- jdk8
- Running PostgreSQL DB

Make sure you have the following environment variables configured (usually you could also link to official guides/ website):
- JAVA_HOME
- CATALINA_HOME
- MAVEN_HOME
- M2_HOME
- DB_URL = connection string for postgresql jdbc drier
- DB_USERNAME = user name for db
- DB_PASSWORD = password for user for PG DB
Notice! This app should use the above environment variables for the DB.... but we happen to have hardcoded it in this current version.


## Setup

1. clone the application from repository

> git clone https://github.com/tdeng3/ShoppingServer.git

1. setup tomcat

- Manually:
    - package into a war with maven:
        > mvn clean package
    - deploy to tomcat by copying the war to the `webapps` folder in Tomcat Directory
    - run startup.sh/startup.bat in tomcat folder
    - navigate to {URL}
- IDE:
    - setup tomcat to run virtually within your ide
    - startup tomcat and navigate to {URL}

- Testing Jenkins
# Contributors
Tianyuan Deng

