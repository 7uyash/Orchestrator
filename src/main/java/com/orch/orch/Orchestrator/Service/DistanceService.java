package com.orch.orch.Orchestrator.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class DistanceService {
    public double calculateDistance(String origin, String destination) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://router.project-osrm.org/route/v1/driving/" + origin + ";" + destination + "?overview=false";
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> routes = (List<Map<String, Object>>) response.get("routes");
            Map<String, Object> firstRoute = routes.get(0);
            return (Double) firstRoute.get("distance") / 1000; // Convert meters to kilometers
        } catch (Exception e) {
            // Handle error (e.g., API unavailable)
            return -1;
        }
    }
}