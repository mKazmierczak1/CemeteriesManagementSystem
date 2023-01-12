package com.mkazm.cemeteriesmanagementsystem.repository;

import com.mkazm.cemeteriesmanagementsystem.model.Cemetery;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CemeteryRepository extends Neo4jRepository<Cemetery, Long> {}
