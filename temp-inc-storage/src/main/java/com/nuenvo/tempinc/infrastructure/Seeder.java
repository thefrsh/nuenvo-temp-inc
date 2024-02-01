package com.nuenvo.tempinc.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
class Seeder {

  @Value("classpath:db/data/ClearSeed.sql")
  private Resource script;

  private final DataSource dataSource;

  @EventListener(value = ApplicationReadyEvent.class)
  public void seed() {

    var populator = new ResourceDatabasePopulator(
      false, false, StandardCharsets.UTF_8.name(), script
    );
    populator.execute(dataSource);
  }
}
