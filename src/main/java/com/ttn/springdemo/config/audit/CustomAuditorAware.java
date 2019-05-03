package com.ttn.springdemo.config.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Chandra Shekhar Paatni on 2/5/19
 */
public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Shekhar");
    }

}
