package com.example.manual;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by alex on 1/25/18.
 */
public class OnMissingObjectMapperCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getBeanFactory().getBeansOfType(ObjectMapper.class).isEmpty();
    }
}
