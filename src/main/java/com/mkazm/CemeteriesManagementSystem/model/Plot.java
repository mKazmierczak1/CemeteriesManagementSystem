package com.mkazm.CemeteriesManagementSystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Plot")
public record Plot(
    @Id long id,
    int row,
    int column,
    String type,
    @Relationship(type = "BURIED_ON_PLOT", direction = Relationship.Direction.INCOMING)
        List<Deceased> deceaseds,
    @Relationship(type = "STANDS_ON", direction = Relationship.Direction.INCOMING)
        List<Tombstone> tombstones) {}
