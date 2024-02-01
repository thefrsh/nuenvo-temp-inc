package com.nuenvo.tempinc.domain.port.primary;

import com.nuenvo.sharedkernel.annotation.domain.Port;
import com.nuenvo.sharedkernel.support.domain.PortType;
import com.nuenvo.tempinc.application.event.AnomalyEvent;

@Port(type = PortType.PRIMARY)
public interface AnomalyFactory {

  void create(AnomalyEvent event);
}
