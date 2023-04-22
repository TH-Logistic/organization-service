FROM openjdk:latest
COPY target/organization-service-0.0.1.jar organization-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/organization-service-0.0.1.jar"]