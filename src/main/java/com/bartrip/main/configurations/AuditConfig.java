package com.bartrip.main.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bartrip.main.security.SecurityAuditAware;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {
    
    @Bean
    public AuditorAware<String> auditorAware(){
        return new SecurityAuditAware();
    }
}
