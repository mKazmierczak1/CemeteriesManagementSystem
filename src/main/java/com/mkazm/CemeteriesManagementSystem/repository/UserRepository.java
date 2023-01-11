package com.mkazm.CemeteriesManagementSystem.repository;

import com.mkazm.CemeteriesManagementSystem.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {}
