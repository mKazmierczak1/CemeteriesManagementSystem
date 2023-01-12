package com.mkazm.cemeteriesmanagementsystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Sector")
public record Sector(
    @Id long id,
    String name,
    @Relationship(type = "PLOT_IS_ON_SECTOR", direction = Relationship.Direction.INCOMING)
        List<Plot> plots) {

  public void addPlot(Plot plot) {
    plots.add(plot);
  }
}
