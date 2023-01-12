package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;
import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Burial")
public record Burial(
    @Id long id,
    Instant burial_date,
    String city,
    String street,
    String number,
    @Relationship(type = "BURIED_IN_BURIAL", direction = Relationship.Direction.INCOMING)
        List<Deceased> deceaseds) {}
