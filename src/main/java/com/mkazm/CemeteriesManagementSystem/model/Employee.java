package com.mkazm.CemeteriesManagementSystem.model;

import java.util.List;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "Employee", labels = "User")
public class Employee extends User {

  public Employee(User user) {
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
  }
}
