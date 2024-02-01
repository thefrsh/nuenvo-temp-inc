package com.nuenvo.tempinc.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "anomalies")
class AnomalyProjection {

  @Id
  private Long id;

  private Long thermometerId;

  private Long roomId;

  private Double temperature;

  private Double deviation;

  private Integer timestamp;
}
