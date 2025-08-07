package com.patientservice.patientservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAware();
    }

}
