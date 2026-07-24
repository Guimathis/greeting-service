package com.guimathis.greeting_service.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(value = "greeting-service")
@RefreshScope
@Getter
@Setter
@NoArgsConstructor
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}
