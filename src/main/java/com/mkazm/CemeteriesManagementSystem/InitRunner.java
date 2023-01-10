package com.mkazm.CemeteriesManagementSystem;

import com.mkazm.CemeteriesManagementSystem.dao.Neo4jDao;
import com.mkazm.CemeteriesManagementSystem.generator.ModelGenerator;
import com.mkazm.CemeteriesManagementSystem.generator.QueryGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

  private final Neo4jDao dao;
  private final QueryGenerator queryGenerator;
  private final ModelGenerator modelGenerator;

  @Override
  public void run(ApplicationArguments args) {
    var cemetery = modelGenerator.generateCemetery();
    var query = queryGenerator.createCemeteryQuery(cemetery);

    System.out.println("Started inserting: " + cemetery);
    System.out.println("Query: " + query);

    dao.insertBatch(query);

    System.out.println("Insert completed!");
  }
}
