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
  private String firstName;
  private String lastName;
  private String city;
  private String street;
  private String number;
  private String email;
  private String phoneNumber;

  @Relationship(type = "RESERVED_BY", direction = Relationship.Direction.INCOMING)
  List<Reservation> reservations;

  @Relationship(type = "COMMISSIONED_BY", direction = Relationship.Direction.INCOMING)
  List<Burial> burials;

  @Relationship(type = "PAID_BY", direction = Relationship.Direction.INCOMING)
  List<Payment> payments;
}
