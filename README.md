# springboot-swagger-jpa-stack

It's a common practice to start a Java project with some goals in mind.

If you want to build RESTful APIs with DB as the backend, you may think of:

- Using [Spring Boot](http://projects.spring.io/spring-boot/) because it brings in great productivity and simplifies Java development;
- Using [Swagger](https://github.com/swagger-api/swagger-ui) so make exposing and documenting RESTful APIs fun;
- Using JPA because it's standard and makes talking to RDBMS easy;
- Using [H2](https://www.h2database.com) as an embedded database for local development and testing;
- Using [Flyway](https://flywaydb.org/) to make database upgrades / patches as code;
- Using [micrometer](http://micrometer.io/) to expose Prometheus-style metrics;
- Using Spring Boot Test Framework with Junit, [Rest Assured](https://github.com/rest-assured/rest-assured) for testing.
- etc.

But make all these framworks fully integrated may take some effort.

So the aim of this sample Java project is to integrate them with some practices and sample code for you to start with.

There is also a bonus: a workable `Dockerfile` which supports multi-stage!

The major components include:

- **Spring Boot v2.2.x**
  - org.springframework.boot:spring-boot-starter-web
  - org.springframework.boot:spring-boot-starter-data-jpa
  - org.springframework.boot:spring-boot-starter-log4j2
  - org.springframework.boot:spring-boot-starter-actuator
- **Swagger v2.9.x**
  - io.springfox:springfox-swagger2
  - io.springfox:springfox-swagger-ui
- **Flyway v6.0.x**
  - org.flywaydb:flyway-core
- **H2 v1.4.x**
  - com.h2database:h2
- **Prometheus support with micrometer**
  - io.micrometer:micrometer-registry-prometheus
- **Testing**
  - org.springframework.boot:spring-boot-starter-test
  - junit:junit
  - io.rest-assured:rest-assured


## File Structure

The project follows a series of conventions / best practices of Maven, Spring Boot and Flyway.

```
$ tree .
.
├── Dockerfile
├── LICENSE
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── app
    │   │       ├── Application.java
    │   │       ├── config
    │   │       │   └── SwaggerConfig.java
    │   │       ├── controller
    │   │       │   ├── GreetingController.java
    │   │       │   └── StudentController.java
    │   │       ├── model
    │   │       │   ├── Greeting.java
    │   │       │   └── Student.java
    │   │       └── repository
    │   │           └── StudentRepository.java
    │   └── resources
    │       ├── application-dev.yml
    │       ├── application.yml
    │       ├── bootstrap.yml
    │       └── db
    │           └── migration
    │               ├── V1.0.0__initial.sql
    │               └── V1.0.1__add_person.sql
    └── test
        └── java
            └── app
                └── ApplicationTests.java
```

## Get Started

Make sure you have Maven 3.x and JDK 1.8+ installed.

```
$ java -version
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_242-b08)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.242-b08, mixed mode)

$ mvn -version
Apache Maven 3.6.2 ...
```

Then let's get started:

```
$ mvn clean package
$ java -Dspring.profiles.active=dev -jar target/springboot-swagger-jpa-stack-1.0.0-SNAPSHOT.jar
```

> Notes:
> 1. Activate `dev` profile while running locally;
> 2. The app serves at port `8080`, as usual.


## Play With It

### Access Swagger UI

Open a browser and navigate to: http://localhost:8080/swagger-ui.html

```
$ open http://localhost:8080/swagger/index.html
```

![swagger-ui](misc/screenshot-swagger.png "Swagger UI")

> Notes: All the APIs can be playing through the UI, do try it out!

### See What Actuator Offers

A list out-of-the-box Actuator services have been exposed, in `dev` profile.

![actuator-services](misc/screenshot-actuator-services.png "Actuator Services")

The `health` with DB info: http://localhost:8080/actuator/health

![actuator-health](misc/screenshot-actuator-health.png "Actuator health")

The `Flyway` info: http://localhost:8080/actuator/flyway

![actuator-flyway](misc/screenshot-actuator-flyway.png "Actuator flyway")

The Prometheus metrics: http://localhost:8080/actuator/prometheus

![actuator-prometheus](misc/screenshot-actuator-prometheus.png "Actuator prometheus")


### Access H2 Console

Open a browser and navigate to: http://localhost:8080/h2-console

![h2-login](misc/screenshot-h2-login.png "H2 Login")

Make sure
1. **JDBC URL** is: `jdbc:h2:mem:testdb`
2. **User Name** is: sa
3. **Password** is empty string.

Click the Connect button and we can play with the database.

![h2-main](misc/screenshot-h2-main.png "H2 Main")

### 

## References

1. Spring Boot with Docker: https://spring.io/guides/gs/spring-boot-docker/
2. Some Dockerfile experience: https://github.com/appsody/stacks/tree/master/incubator/java-spring-boot2

