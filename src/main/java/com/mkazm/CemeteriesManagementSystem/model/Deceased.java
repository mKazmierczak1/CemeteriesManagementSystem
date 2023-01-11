package com.mkazm.CemeteriesManagementSystem.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;

@Node("Deceased")
public record Deceased(
    @Id long id,
    String first_name,
    String last_name,
    String pesel,
    Instant birth_date,
    Instant death_date) {}
