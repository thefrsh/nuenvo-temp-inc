package com.nuenvo.tempinc.domain.port.primary;

import com.nuenvo.sharedkernel.annotation.domain.Port;
import com.nuenvo.sharedkernel.support.domain.PortType;
import com.nuenvo.tempinc.application.event.ReadingEvent;

@Port(type = PortType.PRIMARY)
public interface ReadingFactory {

  ReadingEvent create();
}
