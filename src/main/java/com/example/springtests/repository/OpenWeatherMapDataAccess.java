package com.example.springtests.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class OpenWeatherMapDataAccess implements WeatherDataAccess {

    private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapDataAccess.class);
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    private final RestTemplate restTemplate;
    private final String accessKey;

    // --map.access.key=new-secret-key --another.param=value --second.param=value2
    public OpenWeatherMapDataAccess(final RestTemplate restTemplate, @Value("${map.access.key}") String accessKey) {
        logger.info("injected value: [{}]", accessKey);
        this.accessKey = accessKey;
        this.restTemplate = restTemplate;
    }

    @Override
    public String getWeatherForCity(String city) {
        return restTemplate.getForObject(URL + city, String.class);
    }
}
