package com.nuenvo.tempinc.domain.model;

import com.nuenvo.sharedkernel.annotation.domain.DomainAggregateRoot;
import com.nuenvo.sharedkernel.support.domain.BaseAggregateRoot;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

@Setter
@Entity
@Table(name = "anomalies")
@DomainAggregateRoot
@SequenceGenerator(
  name = "anomalies_gen",
  sequenceName = "anomalies_seq",
  allocationSize = 1
)
@SuppressWarnings(value = "unused")
public class Anomaly extends BaseAggregateRoot {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "anomalies_gen"
  )
  @Setter(value = AccessLevel.NONE)
  private Long id;

  @Column(
    nullable = false,
    updatable = false
  )
  private Integer timestamp;

  @Column(
    nullable = false,
    updatable = false
  )
  private Double temperature;

  @Column(
    nullable = false,
    updatable = false
  )
  private Double deviation;

  @ManyToOne
  @JoinColumn(name = "thermometer_id", referencedColumnName = "id")
  private Thermometer thermometer;

  @ManyToOne
  @JoinColumn(name = "room_id", referencedColumnName = "id")
  private Room room;
}
