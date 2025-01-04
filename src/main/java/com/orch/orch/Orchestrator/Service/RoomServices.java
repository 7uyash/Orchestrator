package com.orch.orch.Orchestrator.Service;

import com.orch.orch.Orchestrator.Entities.Room;
import com.orch.orch.Orchestrator.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServices {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> searchRooms(String location, double maxPrice) {
        return roomRepository.findByLocationAndPricePerMonthLessThanEqual(location, maxPrice);
    }
}
