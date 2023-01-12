package com.mkazm.CemeteriesManagementSystem.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Tombstone")
public record Tombstone(@Id long id, String type) {}
