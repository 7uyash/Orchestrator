package com.orch.orch.Orchestrator.Service;

import com.orch.orch.Orchestrator.Entities.Application;
import com.orch.orch.Orchestrator.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public boolean applyForRoom(Long userId, Long roomId) {
        Application application = new Application();
        application.setUserId(userId);
        application.setRoomId(roomId);
        application.setStatus("Pending");
        application.setApplicationDate(LocalDate.now());
        applicationRepository.save(application);
        return true;
    }

    public boolean cancelApplication(Long applicationId) {
        Optional<Application> application = applicationRepository.findById(applicationId);
        if (application.isPresent()) {
            application.get().setStatus("Cancelled");
            applicationRepository.save(application.get());
            return true;
        }
        return false;
    }

    public List<Application> getApplicationsByUser(Long userId) {
        return applicationRepository.findByUserId(userId);
    }
}

