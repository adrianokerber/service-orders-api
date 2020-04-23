# Service Orders API

This project is a [Spring](https://spring.io/) REST API developed based on the free course from AlgaWorks.

The API connects to a MySQL database (DB).

## 🛠 First steps

- Install Java SDK (JDK 11 >) and set `JAVA_HOME` environment variable to your system pointing to the SDK path. Note: We developed using Java 14
- Install [Spring Tools](https://spring.io/tools) based on your prefered IDE.
    - Personal note: we developed using [VSCode](https://code.visualstudio.com/) but we recommend the [IntelliJ](https://www.jetbrains.com/idea/) based on its sugar 😉
- Configure a MySQL DB to run locally based on `application.properties` configuration or edit to configure another MySQL database

## ⛏ Usage

Once running the application you can choose the contract language by setting the header `Accept` as - `application/json` or `application/xml`

## ⚖️ Dependencies

All project dependencies are available at pom.xml since this project uses Maven.

- [MySQL](https://www.mysql.com/) for local database
- [Flyway](https://flywaydb.org/)
- [Jakarta Persistance (A.k.a: JPA)](https://projects.eclipse.org/projects/ee4j.jpa) used with [Hibernate](https://hibernate.org/) to enable ORM configuration
- [Jakarta Bean Validation](https://projects.eclipse.org/projects/ee4j.bean-validation)

## 🚀 Roadmap

Roadmap for __2020__.

- [x] Create Spring project
- [x] Add MySQL database connection
- [x] Add DB migration control using Flyway
- [x] Divide responsabilities among `API` and `Domain` (Business logic)
- [x] Add ORMs and validations using JPA
- [ ] Create DTOs to avoid exposing unnecessary or sensitive data