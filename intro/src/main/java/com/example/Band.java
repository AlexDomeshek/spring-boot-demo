package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@ConfigurationProperties(prefix = "beatles")
@Component
public class Band {
    private List<String> members = new ArrayList<String>();

    public List<String> getMembers() {
        return members;
    }

    @PostConstruct
    public void init() {
        System.out.println("Band members: " + members);
    }
}

