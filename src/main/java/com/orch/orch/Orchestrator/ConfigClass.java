package com.orch.orch.Orchestrator;

import com.orch.orch.Orchestrator.Entities.Room;
import com.orch.orch.Orchestrator.Repository.RoomRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Configuration
public class ConfigClass {

    @Bean
    CommandLineRunner commandLineRunner(RoomRepository roomRepository) {

        return args -> {
          Room room1 = new Room("Essex", 500, "English", 5.5);
          Room room2 = new Room("London", 512, "English", 6.7);

            roomRepository.saveAll(List.of(room1, room2));
        };
    }
}
