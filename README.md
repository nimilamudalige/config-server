# PulseFit — Config Server

## Project Description

Centralizes and externalizes configuration for every PulseFit microservice
(`member-service`, `class-service`, `booking-service`) and the `api-gateway`.
Runs with the Spring Cloud Config Server's `native` profile, serving YAML
files straight from `src/main/resources/config-repo` on the classpath — no
external Git repository dependency, so the server works immediately after
`mvn clean package`.

Each service imports its configuration on startup with
`spring.config.import: optional:configserver:${CONFIG_SERVER_URL}`, so a
config change here (e.g. a new Gateway route, a changed DB pool size) can be
rolled out without touching the individual service's own `application.yml`.

## Technology Stack

- Java 25
- Spring Boot 4.0.8
- Spring Cloud 2025.1.3 — Config Server (native profile) + Eureka Client
- PM2 (process management on the deployed VM)

## Configuration files served

| File | Applies to |
|---|---|
| `config-repo/application.yml` | Every service (Eureka, management endpoints, logging) |
| `config-repo/api-gateway.yml` | `api-gateway` — routes + CORS |
| `config-repo/member-service.yml` | `member-service` — MySQL + Cloud Storage bucket |
| `config-repo/class-service.yml` | `class-service` — MySQL |
| `config-repo/booking-service.yml` | `booking-service` — MongoDB + Firestore |

## Setup / Getting Started

### Prerequisites

- Java 25 JDK, Maven 3.9+
- A running Eureka Service Registry (see `service-registry`) for full
  functionality, though the config server itself will still serve config
  even if Eureka is briefly unreachable (`fail-fast: false` on clients).

### Run locally

```bash
mvn clean package
java -jar target/config-server.jar
```

Verify: `curl http://localhost:8888/member-service/default` should return
the merged `application.yml` + `member-service.yml` configuration as JSON.

## Student Information

- **Student Name:** Pasan Nimila
- **Student Number:** 2301692034
- **Slack Handle:** pasan_nimila
- **GCP Project ID:** pulsefit-capstone
