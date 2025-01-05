package com.orch.orch.Orchestrator.Controller;

import com.orch.orch.Orchestrator.Entities.Room;
import com.orch.orch.Orchestrator.Service.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomServices roomService;


    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Room>> searchRooms(
            @RequestParam String location,
            @RequestParam double maxPrice) {
        return ResponseEntity.ok(roomService.searchRooms(location, maxPrice));
    }
}

