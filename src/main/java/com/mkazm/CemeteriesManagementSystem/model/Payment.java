package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Payment")
public record Payment(
        @Id long id, double amount, Instant datetime, String city, String street, String number) {}
