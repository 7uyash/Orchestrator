package com.orch.orch.Orchestrator.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {
    private final String apiKey = "your_openweather_api_key";

    public Map<String, Object> getWeather(String location) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&units=metric";
        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            // Handle error (e.g., API unavailable)
            return Map.of("error", "Unable to fetch weather data");
        }
    }
}