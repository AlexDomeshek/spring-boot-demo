package com.example;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

/**
 * Created by alex on 1/22/18.
 */
public class CPUNumberHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int processors = Runtime.getRuntime().availableProcessors();
        builder.withDetail("cpu#", processors)
                .status(processors > 1 ? Status.UP : Status.DOWN);
    }
}
    