package com.mkazm.cemeteriesmanagementsystem.config;

import com.mkazm.cemeteriesmanagementsystem.generator.ModelGenerator;
import com.mkazm.cemeteriesmanagementsystem.generator.QueryGenerator;
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
