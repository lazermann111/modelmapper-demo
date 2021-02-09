package ru.xpendence.modelmapperdemo.config;


import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@AllArgsConstructor
public class BlobServiceHealthIndicator implements HealthIndicator {


    private final RestTemplate restTemplate;

    @Override
    public Health health() {

        try {
            restTemplate.getForObject(URI.create("your/other/service"), String.class);
            return Health.up().build();
        } catch (Exception e) {
            return Health.outOfService().withException(e).build();
        }

    }
}
