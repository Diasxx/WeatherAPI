package com.example.api.controllers;

import com.example.api.model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    private static final String API_KEY = "";
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json";

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {

        String apiUrlWithParams = String.format("%s?key=%s&q=%s", API_URL, API_KEY, city);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(apiUrlWithParams, WeatherResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }
}
