package com.mkazm.cemeteriesmanagementsystem.model;

import java.time.Instant;
import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Reservation")
public record Reservation(
    @Id long id,
    Instant due_to_date,
    String city,
    String street,
    String number,
    @Relationship(type = "IS_FOR", direction = Relationship.Direction.OUTGOING) List<Plot> plots,
    @Relationship(type = "PAYMENT_FOR", direction = Relationship.Direction.INCOMING)
        List<Payment> payments,
    @Relationship(type = "", direction = Relationship.Direction.INCOMING) List<Burial> burials) {}
