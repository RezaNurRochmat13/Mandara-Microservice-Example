# Mandara-Microservice-Example
Mandara Microservices with Java Spring. Built using Spring Boot, JPA, Hibernate, Eureka Service Discovery, Lombok, Postgres, Actuator

# Presequities
- Java 1.8
- Maven Build Tools
- Docker Engine

# How to run
## Running native without docker
- Clone this repository
- First, run the eureka service discovery server on `eureka` directory using command `mvn spring-boot:run`
- After run eureka server, you can run service user and product. The service user and product will be registered on eureka server
- After running, you can navigate on service endpoint using actuator `host:port/actuator/health`

## Running with docker
- Clone this repository
- First, navigate to eureka directory and build the eureka server as docker images using command `docker build -t eureka-server .`
- After build, you can run docker images using command `docker run -d --rm -p 8761:8761`
- After running the eureka server, you can build the docker images for user and product using same command using `docker build -t service-name .`
- After build the user and product service, you can running the docker images user and product using command `docker run -d --rm -p port:port`
