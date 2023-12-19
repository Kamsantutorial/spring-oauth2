package com.example.oauth2.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author KAMSAN TUTORIAL
 */
@Configuration
@EntityScan(basePackages = "com.example.oauth2")
@EnableJpaAuditing
public class AppConfig {


}
