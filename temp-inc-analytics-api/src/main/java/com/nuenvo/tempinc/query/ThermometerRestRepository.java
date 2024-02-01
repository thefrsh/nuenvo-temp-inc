package com.nuenvo.tempinc.query;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ThermometerRestRepository extends Repository<ThermometerProjection, Long> {

  @Query(value = """
    SELECT th.id, COUNT(a) AS anomalies_count
    FROM thermometers AS th
    LEFT JOIN anomalies a on th.id = a.thermometer_id
    WHERE a.deviation > :threshold
    GROUP BY th.id
  """, nativeQuery = true)
  List<ThermometerProjection> findAllByThreshold(@Param(value = "threshold") Integer threshold);
}
