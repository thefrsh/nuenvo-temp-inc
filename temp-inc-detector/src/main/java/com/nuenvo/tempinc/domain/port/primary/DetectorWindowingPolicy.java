package com.nuenvo.tempinc.domain.port.primary;

import com.nuenvo.sharedkernel.annotation.domain.Port;
import com.nuenvo.sharedkernel.support.domain.PortType;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.application.event.ReadingEvent;

import java.util.List;

@Port(type = PortType.PRIMARY)
public interface DetectorWindowingPolicy {

  List<AnomalyEvent> detect(ReadingEvent event);
}
