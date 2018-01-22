package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alex on 1/22/18.
 */

@Component
public class MyInfoContributor implements InfoContributor{

    @Autowired
    private GenericWebApplicationContext applicationContext;

    @Override
    public void contribute(Info.Builder builder) {
        List<String> listenerNames = applicationContext.getApplicationListeners().stream().map(
                l -> l.getClass().getName()
        ).collect(Collectors.toList());
        builder.withDetail("Application Listeners", listenerNames);
    }
}
//