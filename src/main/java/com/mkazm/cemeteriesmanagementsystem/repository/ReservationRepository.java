package com.mkazm.cemeteriesmanagementsystem.repository;

import com.mkazm.cemeteriesmanagementsystem.model.Reservation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReservationRepository extends Neo4jRepository<Reservation, Long> {}
