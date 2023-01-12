package com.mkazm.cemeteriesmanagementsystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(primaryLabel = "Manager", labels = "User")
public class Manager extends User {

  @Relationship(type = "ORDERED_BY", direction = Relationship.Direction.INCOMING)
  List<Exhumation> exhumations;

  public Manager(User user, List<Exhumation> exhumations) {
    super(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getCity(),
        user.getStreet(),
        user.getNumber(),
        user.getEmail(),
        user.getPhoneNumber(),
        List.of(),
        List.of(),
        List.of());

    this.exhumations = exhumations;
  }

  public List<Exhumation> getExhumations() {
    return exhumations;
  }
}
