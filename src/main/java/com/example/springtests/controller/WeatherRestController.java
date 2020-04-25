package com.example.springtests.controller;

import com.example.springtests.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherRestController {

    private final WeatherService weatherService;

    public WeatherRestController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/warsaw-weather")
    String getWeatherForWarsaw() {
        return weatherService.getWeatherForCity("warsaw");
    }
}
