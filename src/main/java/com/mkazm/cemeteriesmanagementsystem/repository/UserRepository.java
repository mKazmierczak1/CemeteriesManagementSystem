package com.mkazm.cemeteriesmanagementsystem.repository;

import com.mkazm.cemeteriesmanagementsystem.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {}
