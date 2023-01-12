package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Payment")
public record Payment(
    @Id long id,
    double amount,
    Instant datetime,
    String city,
    String street,
    String number,
    @Relationship(type = "INVOICE_FOR", direction = Relationship.Direction.INCOMING)
        Invoice invoice,
    @Relationship(type = "PAID_FOR", direction = Relationship.Direction.OUTGOING) Burial burial,
    @Relationship(type = "PAID_FOR", direction = Relationship.Direction.OUTGOING)
        Tombstone tombstone) {}
