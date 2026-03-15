package com.EmployeeManagement.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class    RestTemplateConfig {

//    @Bean
//    public RestClient restClient(RestClient.Builder builder){
//        return builder
//                .baseUrl("http://localhost:8080/")
//                .build();
//    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
