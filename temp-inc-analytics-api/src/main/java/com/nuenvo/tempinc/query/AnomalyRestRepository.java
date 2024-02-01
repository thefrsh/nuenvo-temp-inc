package com.nuenvo.tempinc.query;

import org.springframework.data.repository.Repository;

import java.util.List;

interface AnomalyRestRepository extends Repository<AnomalyProjection, Long> {

  List<AnomalyProjection> findAllByThermometerId(Long id);

  List<AnomalyProjection> findAllByRoomId(Long id);
}
