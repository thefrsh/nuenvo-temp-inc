package com.nuenvo.tempinc.infrastructure;

import com.nuenvo.tempinc.domain.model.Thermometer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ThermometerRepository extends Repository<Thermometer, Long> {

  Optional<Thermometer> findById(Long id);
}
