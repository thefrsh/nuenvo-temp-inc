package com.nuenvo.tempinc.domain.model;

import com.nuenvo.sharedkernel.support.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
@SequenceGenerator(
  name = "rooms_gen",
  sequenceName = "rooms_seq",
  allocationSize = 1
)
@SuppressWarnings(value = "unused")
public class Room extends BaseEntity {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "rooms_gen"
  )
  private Long id;

  @OneToMany(mappedBy = "room")
  private List<Thermometer> thermometers;

  @OneToMany(mappedBy = "room")
  private List<Anomaly> anomalies;
}
