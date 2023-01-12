package com.mkazm.cemeteriesmanagementsystem.model;

import java.time.Instant;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Exhumation")
public record Exhumation(@Id long id, Instant exhumation_date, String reason) {}
