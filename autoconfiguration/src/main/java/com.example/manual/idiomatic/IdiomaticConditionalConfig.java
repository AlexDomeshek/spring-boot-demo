package com.example.manual.idiomatic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alex on 1/25/18.
 */


@Configuration
@ConditionalOnClass(ObjectMapper.class)
public class IdiomaticConditionalConfig {

    @Bean
    @ConditionalOnMissingBean(name = "objectMapper")
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }
}
