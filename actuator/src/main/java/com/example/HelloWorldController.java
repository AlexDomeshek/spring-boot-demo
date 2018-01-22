package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/18/18.
 */

@RestController
public class HelloWorldController {

    @RequestMapping("/sayHello")
    String sayHello(){
        return "Hello from Actuator";
    }
}
