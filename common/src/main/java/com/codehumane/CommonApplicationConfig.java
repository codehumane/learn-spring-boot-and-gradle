package com.codehumane;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 어플리케이션 공통 설정
 * Created by chogh on 9/25/16.
 */
public class CommonApplicationConfig {

    @EnableJpaAuditing
    public class PersistenceConfig {
    }

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json().
                featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).
                modules(new JavaTimeModule()).
                build();
    }

}
