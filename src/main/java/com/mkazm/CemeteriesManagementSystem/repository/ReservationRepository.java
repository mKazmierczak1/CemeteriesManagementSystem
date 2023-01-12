package com.mkazm.CemeteriesManagementSystem.repository;

import com.mkazm.CemeteriesManagementSystem.model.Reservation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReservationRepository extends Neo4jRepository<Reservation, Long> {}
