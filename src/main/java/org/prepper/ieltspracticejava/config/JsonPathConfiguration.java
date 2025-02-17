package org.prepper.ieltspracticejava.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import org.springframework.context.annotation.Bean;

import java.util.EnumSet;
import java.util.Set;

@org.springframework.context.annotation.Configuration
public class JsonPathConfiguration {
    @Bean
    public Configuration itongzhuoConfiguration() {
        Configuration.setDefaults(new Configuration.Defaults() {
            @Override
            public JsonProvider jsonProvider() {
                ObjectMapper objectMapper = new ObjectMapper();
                // 没有效果，不知道为什么
                // objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return new JacksonJsonProvider(objectMapper);
            }

            @Override
            public Set<Option> options() {
                return EnumSet.noneOf(Option.class);
            }

            @Override
            public MappingProvider mappingProvider() {
                return new JacksonMappingProvider();
            }
        });
        return Configuration.defaultConfiguration();
    }
}
