# assignment
this is an internal assignment

#Swagger
----------
http://localhost:8081/swagger-ui/index.html# -- company-service
http://localhost:8082/swagger-ui/index.html# -- employee-service

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
