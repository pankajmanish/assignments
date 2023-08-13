#define base docker image
FROM openjdk:17-oracle
EXPOSE 8082
LABEL maintainer="manish"
ADD target/employee-service.jar employeeservice.jar
ENTRYPOINT ["java", "-jar", "/employeeservice.jar"]
