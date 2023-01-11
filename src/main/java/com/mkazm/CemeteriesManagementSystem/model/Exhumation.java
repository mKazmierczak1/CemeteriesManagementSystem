package com.mkazm.CemeteriesManagementSystem.model;

import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;

@Node("Exhumation")
public record Exhumation(long id, Instant exhumation_date, String reason) {}
