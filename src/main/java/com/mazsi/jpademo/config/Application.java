package com.mazsi.jpademo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "security.token")
@Getter
@Setter
public class Application {

    private String secret;

    private int maxAgeSecond;

}
