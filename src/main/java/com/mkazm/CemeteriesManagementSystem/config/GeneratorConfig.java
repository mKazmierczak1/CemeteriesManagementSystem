package com.mkazm.CemeteriesManagementSystem.config;

import com.mkazm.CemeteriesManagementSystem.generator.ModelGenerator;
import com.mkazm.CemeteriesManagementSystem.generator.QueryGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

  @Bean
  public ModelGenerator modelGeneratorBean() {
    return new ModelGenerator();
  }

  @Bean
  public QueryGenerator queryGeneratorBean() {
    return new QueryGenerator();
  }
}
