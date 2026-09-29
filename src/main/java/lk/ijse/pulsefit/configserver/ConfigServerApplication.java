package lk.ijse.pulsefit.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * PulseFit Platform - Config Server.
 * Centralizes and externalizes configuration for every microservice
 * (member-service, class-service, booking-service) and the api-gateway.
 * Runs with the "native" profile, serving files straight from the
 * classpath /config-repo folder - no external Git dependency, so the
 * server works the moment the jar starts.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
