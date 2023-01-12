package com.mkazm.CemeteriesManagementSystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("Cemetery")
public record Cemetery(
    @Id long id,
    String name,
    String city,
    String street,
    String number,
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
        List<Sector> sectors,
    @Relationship(type = "MANAGES", direction = Relationship.Direction.INCOMING) Manager manager,
    @Relationship(type = "ASSIGNED_TO", direction = Relationship.Direction.INCOMING)
        List<Employee> employees) {

  public Sector getSector(int index) {
    return sectors.get(index);
  }

  public int getSectorsSize() {
    return sectors.size();
  }
}
