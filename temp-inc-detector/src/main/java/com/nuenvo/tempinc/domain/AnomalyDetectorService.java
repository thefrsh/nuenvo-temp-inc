package com.nuenvo.tempinc.domain;

import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.application.event.ReadingEvent;

import java.util.List;

interface AnomalyDetectorService {

  List<AnomalyEvent> detect(List<ReadingEvent> window);
}
