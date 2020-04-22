# Service Orders API

A [Spring](https://spring.io/) REST API developed based on the free course from AlgaWorks.

## First steps

- Install [VSCode Spring plugin](https://spring.io/tools) or choose another IDE
- Install Java SDK (JDK 11 >) and set `JAVA_HOME` environment variable to your system pointing to the SDK path. Note: We developed using Java 14

## Usage

Once running the application you can choose the contract language by setting the header `Accept` as - `application/json` or `application/xml`

## Dependencies

All project dependencies are available at pom.xml since this project uses Maven.

- [MySQL](https://www.mysql.com/) for local database
- [Flyway](https://flywaydb.org/)
- [Jakarta Persistance (A.k.a: JPA)](https://projects.eclipse.org/projects/ee4j.jpa) used with [Hibernate](https://hibernate.org/) to enable ORM configuration
- [Jakarta Bean Validation](https://projects.eclipse.org/projects/ee4j.bean-validation)

## Roadmap

Roadmap for __2020__.

- [ ] Create base project