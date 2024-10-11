package dev.itsjofi.simpledigitalwallet.modules.common.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean
    public StrongPasswordEncryptor passwordEncryptor() {
        return new StrongPasswordEncryptor();
    }
}
