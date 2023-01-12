package com.mkazm.CemeteriesManagementSystem.repository;

import com.mkazm.CemeteriesManagementSystem.model.Cemetery;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CemeteryRepository extends Neo4jRepository<Cemetery, Long> {}
