package com.mkazm.CemeteriesManagementSystem.generator;

import com.github.javafaker.Faker;
import com.mkazm.CemeteriesManagementSystem.model.*;
import java.util.List;

public class ModelGenerator {

  private final Faker faker;

  private static final List<String> grave_type_names =
      List.of("single", "double", "child", "family", "mass");

  private static final List<String> tombstone_type_names =
      List.of("Upright", "Slant", "Flat", "Bevel", "Bench", "Wing");

  private static final List<String> user_type_names =
      List.of("logged", "admin", "manager", "employee");

  private static final List<String> cemetery_names =
      List.of(
          "Grabiszynski",
          "Osobowicki",
          "Pawlowice",
          "Jerzmanowo",
          "Wolski",
          "Wilanowski",
          "Mariawicki",
          "Yardway",
          "Mortling",
          "Ormshire",
          "Worthwood",
          "Parton",
          "St. Clare",
          "Chourmondeley",
          "Middleborough",
          "Corlach");

  private static final List<String> exhumation_reasons =
      List.of(
          "Moved to another cemetery",
          "For the further forensic examination",
          "Request of a attorney",
          "Public health reasons");

  public ModelGenerator() {
    faker = new Faker();
  }

  public Burial generateBurial() {
    return new Burial(
        faker.random().nextLong(),
        faker.date().birthday().toInstant(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber());
  }

  public Cemetery generateCemetery() {
    return new Cemetery(
        faker.random().nextLong(),
        cemetery_names.get(faker.random().nextInt(cemetery_names.size())),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber());
  }

  public Deceased generateDeceased() {
    return new Deceased(
        faker.random().nextLong(),
        faker.name().firstName(),
        faker.name().lastName(),
        faker.numerify("###########"),
        faker.date().birthday().toInstant(),
        faker.date().birthday().toInstant());
  }

  public Exhumation generateExhumation() {
    return new Exhumation(
        faker.random().nextLong(),
        faker.date().birthday().toInstant(),
        exhumation_reasons.get(faker.random().nextInt(exhumation_reasons.size())));
  }

  public Invoice generateInvoice() {
    return new Invoice(
        faker.random().nextLong(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber(),
        faker.numerify("###########"),
        faker.company().name());
  }

  public Payment generatePayment() {
    return new Payment(
        faker.random().nextLong(),
        faker.random().nextDouble(),
        faker.date().birthday().toInstant(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber());
  }

  public Plot generatePlot() {
    return new Plot(
        faker.random().nextLong(), faker.random().nextInt(100), faker.random().nextInt(100));
  }

  public Reservation generateReservation() {
    return new Reservation(
        faker.random().nextLong(),
        faker.date().birthday().toInstant(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber());
  }

  public Sector generateSector() {
    return new Sector(faker.random().nextLong(), faker.letterify("?"));
  }

  public Tombstone generateTombstone() {
    return new Tombstone(
        faker.random().nextLong(),
        new TombstoneType(
            0, tombstone_type_names.get(faker.random().nextInt(tombstone_type_names.size()))));
  }

  public User generateUser() {
    return new User(
        faker.random().nextLong(),
        faker.name().firstName(),
        faker.name().lastName(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber(),
        faker.bothify("??????###@mail.com"),
        faker.phoneNumber().phoneNumber());
  }
}
