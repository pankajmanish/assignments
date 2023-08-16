# assignment
this is an internal assignment

#Swagger (localhost)
=======================
To run in local host
--------------------
a) http://localhost:8081/swagger-ui/index.html# -- company-service
b) http://localhost:8082/swagger-ui/index.html# -- employee-service



#PostGreSQL
-------------------
1. Pull docker image

   Execute comand : docker pull postgres

2. Below command:
   a) Creates PostgreSql Database myTestDB. 
   b) Maps it to 5432 port
   c) Creates Postgres user: admin, Password : admin | You can use PgAdmin4 application to access this database.
   d) Maps the Postgres data to persistence storage at d:\postgres_container_folder. Create this folder beforehand.

   docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=myTestDB -v D:\postgres_container_data:/var/lib/postgresql/data --name=postgres_con postgres

3. Microservices (running in docker containers) connecting to Postgres 
   a) at command prompt run : docker inspect postgres_con
   b) Note down the ipaddress mentioned 
   c) at application.properties file, use this ipaddress e.g. below
      
      spring.datasource.url=jdbc:postgresql://[ipaddress]:5432/myTestDB
     #spring.datasource.url=jdbc:postgresql://localhost:5432/myTestDB


#Docker
----------------
Execute below commands in the respective folder of the project in ps or command window, after maven clean and package operations:

1. docker build -t companyservice:latest .
2. docker run -p 8081:8081 --name=compservicename companyservice

3. docker build -t employeeservice:latest .
4. docker run -p 8082:8082 --name=empservicename employeeservice

#Swagger 
============
To execute in docker container
------------------------------
a) http://[your machine ip address]:8081/swagger-ui/index.html# -- company-service
b) http://[your machine ip address]:8082/swagger-ui/index.html# -- employee-service


TODO
----
1. Service discovery using Eureca and spring cloud
2. API gateway implementation