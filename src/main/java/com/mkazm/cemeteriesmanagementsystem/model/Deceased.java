package com.mkazm.cemeteriesmanagementsystem.model;

import java.time.Instant;
import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Deceased")
public record Deceased(
    @Id long id,
    String first_name,
    String last_name,
    String pesel,
    Instant birth_date,
    Instant death_date,
    @Relationship(type = "EXECUTED_ON", direction = Relationship.Direction.INCOMING)
        List<Exhumation> exhumations) {}
