package com.orch.orch.Orchestrator.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CrimeService {
    public Map<String, Object> getCrimeData(String location) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://data.police.uk/api/crimes-street/all-crime?lat={lat}&lng={lng}";
        try {
            return restTemplate.getForObject(url, Map.class, location);
        } catch (Exception e) {
            return Map.of("error", "Unable to fetch crime data");
        }
    }
}