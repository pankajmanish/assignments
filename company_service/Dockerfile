#define base docker image
FROM openjdk:17-oracle
EXPOSE 8081
LABEL maintainer="manish"
ADD target/company-service.jar companyservice.jar
ENTRYPOINT ["java", "-jar", "/companyservice.jar"]
