package com.example.actuator.components;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/* ============ Custom Health Indicator ========== */

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        builder.up()
                .withDetail("app", "I am Alive")
                .withDetail("error", "Nothing!");

    }

}
