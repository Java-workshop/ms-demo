package com.mhp.demo.ms.operator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fjiang.
 */
@SpringBootApplication
public class OperatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperatorApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
