package com.example.manual;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Conditional;

/**
 * Created by alex on 1/25/18.
 */
public class ConditionalJSonConfig {

    @Conditional(OnMissingObjectMapperCondition.class)
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
