package com.example;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * Created by alex on 1/22/18.
 */
@Component
public class TimePrintingPublicMetrics implements PublicMetrics {

    Date invoked = new Date();

    @Override
    public Collection<Metric<?>> metrics() {

        Date now = new Date();
        Collection<Metric<?>> result = new LinkedHashSet<>();
        result.add(new Metric<Number>("epochMillis", now.getTime()));
        result.add(new Metric<Number>("elapsed", now.getTime() - invoked.getTime()));
        invoked = now;
        return result;
    }
}
