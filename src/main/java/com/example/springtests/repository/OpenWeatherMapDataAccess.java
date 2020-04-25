package com.example.springtests.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class OpenWeatherMapDataAccess implements WeatherDataAccess {

    private final RestTemplate restTemplate;

    public OpenWeatherMapDataAccess(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getWeatherForCity(String city) {
        // TODO: make more generic
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city, String.class);
    }
}
