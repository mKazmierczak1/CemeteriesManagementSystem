package com.mkazm.CemeteriesManagementSystem.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Invoice")
public record Invoice(
        @Id long id, String city, String street, String number, String nip, String company_name) {}
