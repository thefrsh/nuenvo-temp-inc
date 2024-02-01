package com.nuenvo.tempinc.application.event;

public record ReadingEvent(
  Double temperature,
  Integer timestamp,
  Long roomId,
  Long thermometerId
) { }
