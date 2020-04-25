package com.example.springtests.service;

import com.example.springtests.repository.WeatherDataAccess;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherDataAccess weatherDataAccess;

    public WeatherServiceImpl(final WeatherDataAccess weatherDataAccess) {
        this.weatherDataAccess = weatherDataAccess;
    }

    @Override
    public String getWeatherForCity(String city) {
        return weatherDataAccess.getWeatherForCity(city);
    }
}
