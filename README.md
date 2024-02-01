# Temp Inc.

A recruitment task for Kontakt.io. A simple Java and Spring Boot based system for real-time temperature
measurements streaming and persistence. The application provides a very basic REST API to perform domain operations using HTTP.

### Requirements

* Java 17 or higher (developed using Liberica JDK 21)
* Docker, Docker-Compose

### Checkout

The repository uses a submodule (shared-kernel) containing some additional classes and decorators mostly designed
to implement Domain Driven Design and Hexagonal Architecture. Make sure to execute:

``git submodule update --init --recursive``

### dotenv files

Two of the modules requires a .env file containing some properties to connect to the database. Please create them in:
* temp-inc-storage/src/main/resources
* temp-inc-analytics-api/src/main/resources

The structure of those files shall look like this (with some example values):
```
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_URL=jdbc:postgresql://localhost:5432/postgres
```

### Database, Kafka

The project depends on two third-party services: Postgresql and Kafka.
Those shall be run using Docker-Compose before the application is started.

``docker-compose up -d``

### Configuration

* temp-inc-generator - in the application properties you can change `spring.integration.polling`
if you want the generator to publish messages at different rate
* temp-inc-detector - in the application properties you can change `anomalies.detector.algorithm` to switch between
two implementations of detecting anomalies: `count-based` (default) or `time-based`. Except of that, you can change
the maximum acceptable `deviation` and `window-size` (a range of readings/time that the average is calculated for).

### Maven modules

The application has been written as microservices and each of them is configured as a Maven module.
When all the previous steps have been done you can start the whole application by:
```
mvn -pl temp-inc-storage spring-boot:run
mvn -pl temp-inc-analytics-api spring-boot:run
mvn -pl temp-inc-detector spring-boot:run
mvn -pl temp-inc-generator spring-boot:run
```

### REST API

The application provides a very basic REST API described in the requirements of this task. You can find an interactive
(Swagger) documentation at: `/api/swagger-ui/index.html`.

### Implementation note

The algorithms used to detect anomalies work as a sliding window advancing by 1 element. It means that one anomaly
may be persisted many times as it's included many times in one window. I wasn't sure about that requirement,
so I decided to stick to that implementation, but I was thinking about persisting only distinct anomalies
or implementing a hopping window as well to not include those same values for the average calculation twice or more.

Due to various factors (technical and non-technical), the application has implemented only basic integration tests
for the REST API, which can be found in the `temp-inc-analytics-api` module.
In other words - my spare time allowed me to do only that much, sorry.
