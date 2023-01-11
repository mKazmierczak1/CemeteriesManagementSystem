package com.mkazm.CemeteriesManagementSystem.repository;

import lombok.RequiredArgsConstructor;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Neo4jDao {
  private final Driver driver;

  public void insertBatch(String query) {
    try (var session = driver.session()) {
      session.executeWrite(transactionContext -> transactionContext.run(new Query(query)));
    }
  }
}
