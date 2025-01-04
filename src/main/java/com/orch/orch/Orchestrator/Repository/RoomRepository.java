package com.orch.orch.Orchestrator.Repository;

import com.orch.orch.Orchestrator.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByLocationAndPricePerMonthLessThanEqual(String location, double maxPrice);
}
