package com.example.springtests;

import com.example.springtests.repository.CommentDbRepository;
import com.example.springtests.repository.DataAccess;
import com.example.springtests.service.CommentService;
import com.example.springtests.service.CommentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestsApplication.class, args);
    }

    // metoda fabryczna??
    @Bean
    CommentDbRepository commentDbRepository() {
        System.out.println("creating commentDbRepository()...");
        return new CommentDbRepository();
    }

    @Bean
    @Primary
    CommentService commentServiceImpl2() {
        return new CommentServiceImpl(commentDbRepository());
    }

    @Bean
    @Primary
    CommentService commentServiceImpl() {
        return new CommentServiceImpl(commentDbRepository());
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

}

// 3 bean'y
// repozytorium - Comments
// serwis - operuje na repozytorium
// contorller - operuje na serwisie
// komunikacja przez interfacy
