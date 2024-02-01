package com.nuenvo.tempinc.application.event;

public record AnomalyEvent(
  Double temperature,
  Integer timestamp,
  Long roomId,
  Long thermometerId,
  Double deviation
) { }
