package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/22/18.
 */

@RestController
public class Controller4Testing {

    @RequestMapping("/sayHello")
    String sayHello(@RequestParam("name") String name){
        return "Hello, "+name;
    }
}