package com.nuenvo.tempinc.infrastructure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringDocConfiguration {

  @Value(value = "${project.version}")
  private String projectVersion;

  @Bean
  GroupedOpenApi groupedOpenApi() {

    return GroupedOpenApi.builder()
      .group("Query")
      .packagesToScan("com.nuenvo.tempinc.query")
      .build();
  }

  @Bean
  OpenAPI openAPI() {

    return new OpenAPI()
      .components(new Components())
      .info(new Info()
        .title("'Always Right Temp Inc' temperature anomalies solution")
        .description("The masters of temperature sensors!")
        .version(projectVersion)
        .contact(
          new Contact()
            .name("Michal Broniewicz")
            .email("mbroniewicz@outlook.com")
        )
      ).externalDocs(
        new ExternalDocumentation()
          .description("README.md")
          .url("https://github.com/thefrsh/nuenvo-temp-inc/blob/master/README.md")
      );
  }
}
