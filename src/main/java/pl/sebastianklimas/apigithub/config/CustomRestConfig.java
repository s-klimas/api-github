package pl.sebastianklimas.apigithub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomRestConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
