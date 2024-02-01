package com.nuenvo.tempinc.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "thermometers")
class ThermometerProjection {

  @Id
  private Long id;

  private Long anomaliesCount;
}
