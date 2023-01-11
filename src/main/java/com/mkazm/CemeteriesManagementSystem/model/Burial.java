package com.mkazm.CemeteriesManagementSystem.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;

@Node("Burial")
public record Burial(@Id long id, Instant burial_date, String city, String street, String number) {}
