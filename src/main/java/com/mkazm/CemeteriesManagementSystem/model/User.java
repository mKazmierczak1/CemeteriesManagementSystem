package com.mkazm.CemeteriesManagementSystem.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("User")
@Data
@AllArgsConstructor
public class User {
  @Id long id;
  private String first_name;
  private String last_name;
  private String city;
  private String street;
  private String number;
  private String email;
  private String phone_number;

  @Relationship(type = "RESERVED_BY", direction = Relationship.Direction.INCOMING)
  List<Reservation> reservations;
}
