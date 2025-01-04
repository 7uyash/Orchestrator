package com.orch.orch.Orchestrator.Controller;

import com.orch.orch.Orchestrator.Entities.Application;
import com.orch.orch.Orchestrator.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<String> applyForRoom(@RequestParam Long userId, @RequestParam Long roomId) {
        boolean success = applicationService.applyForRoom(userId, roomId);
        return success ? ResponseEntity.ok("Application Successful") : ResponseEntity.status(400).body("Failed");
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelApplication(@PathVariable Long id) {
        boolean success = applicationService.cancelApplication(id);
        return success ? ResponseEntity.ok("Application Cancelled") : ResponseEntity.status(400).body("Failed");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Application>> getUserApplications(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByUser(userId));
    }
}
