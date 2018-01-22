package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletRegistration;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by alex on 1/22/18.
 */

@Component
public class AllServletsEndPoint extends AbstractEndpoint<Map<String, String>> {

    @Autowired
    private WebApplicationContext applicationContext;

    public AllServletsEndPoint() {
        super("servlets", false);
    }

    @Override
    public Map<String, String> invoke() {
        Map<String, ? extends ServletRegistration> servletRegistrations = applicationContext.getServletContext().getServletRegistrations();
        return servletRegistrations.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().getClassName()));
    }
}
