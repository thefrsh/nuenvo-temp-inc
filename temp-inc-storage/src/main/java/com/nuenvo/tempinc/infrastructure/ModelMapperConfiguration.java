package com.nuenvo.tempinc.infrastructure;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ModelMapperConfiguration {

  @Bean
  ModelMapper modelMapper() {

    var mapper = new ModelMapper();
    mapper.registerModule(new RecordModule());

    return mapper;
  }
}
