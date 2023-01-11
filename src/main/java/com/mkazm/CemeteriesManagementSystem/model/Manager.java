package com.mkazm.CemeteriesManagementSystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "Manager", labels = "User")
public class Manager extends User {
  public Manager(User user) {
    super(
        user.getId(),
        user.getFirst_name(),
        user.getLast_name(),
        user.getCity(),
        user.getStreet(),
        user.getNumber(),
        user.getEmail(),
        user.getPhone_number(),
        List.of());
  }
}
