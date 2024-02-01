package com.nuenvo.tempinc.domain;

import com.nuenvo.sharedkernel.annotation.infrastructure.DomainRepository;
import com.nuenvo.sharedkernel.support.infrastructure.BaseRepository;
import com.nuenvo.tempinc.domain.model.Anomaly;

@DomainRepository
class AnomalyRepository extends BaseRepository<Anomaly> {

  protected AnomalyRepository() {

    super(Anomaly.class);
  }
}
