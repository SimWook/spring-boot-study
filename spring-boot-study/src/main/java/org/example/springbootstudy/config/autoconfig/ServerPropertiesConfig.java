package org.example.springbootstudy.config.autoconfig;

import org.apache.logging.log4j.util.Strings;
import org.example.springbootstudy.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    public ServerProperties serverProperties(Environment environment) {
        return Binder.get(environment).bind(Strings.EMPTY, ServerProperties.class).get();
    }
}
