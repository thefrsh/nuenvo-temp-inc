package com.nuenvo.tempinc.infrastructure;

import com.nuenvo.tempinc.domain.model.Room;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoomRepository extends Repository<Room, Long> {

  Optional<Room> findById(Long id);
}
