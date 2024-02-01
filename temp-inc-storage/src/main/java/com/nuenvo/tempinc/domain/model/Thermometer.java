package com.nuenvo.tempinc.domain.model;

import com.nuenvo.sharedkernel.support.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "thermometers")
@SequenceGenerator(
  name = "thermometers_gen",
  sequenceName = "thermometers_seq",
  allocationSize = 1
)
@SuppressWarnings(value = "unused")
public class Thermometer extends BaseEntity {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "thermometers_gen"
  )
  private Long id;

  @ManyToOne
  @JoinColumn(name = "room_id", referencedColumnName = "id")
  private Room room;

  @OneToMany(mappedBy = "thermometer")
  private List<Anomaly> anomalies;
}
