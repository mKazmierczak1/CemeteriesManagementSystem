package com.mkazm.CemeteriesManagementSystem.generator;

import com.github.javafaker.Faker;
import com.mkazm.CemeteriesManagementSystem.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ModelGenerator {

  private final Faker faker;

  private static final int MAX_BURIALS_FOR_RESERVATION_AND_PAYMENT = 5;
  private static final int MAX_PAYMENTS_FOR_USER_AND_RESERVATION = 10;
  private static final int MAX_DECEASEDS_FOR_PLOT = 4;
  private static final int MAX_DECEASEDS_FOR_BURIAL = 3;
  private static final int MAX_EXHUMATIONS_FOR_MANAGER = 20;
  private static final int MAX_PLOTS_IN_SECTOR = 50;
  private static final int MAX_PLOTS_FOR_RESERVATION = 5;
  private static final int MAX_RESERVATIONS_FOR_USER = 20;
  private static final int MAX_SECTORS_IN_CEMETERY = 10;
  private static final int MAX_TOMBSTONES_FOR_PLOT = 3;
  private static final int MAX_EMPLOYEES_FOR_CEMETERY = 20;

  private static final List<String> GRAVE_TYPE_NAMES =
      List.of("single", "double", "child", "family", "mass");

  private static final List<String> TOMBSTONE_TYPE_NAMES =
      List.of("Upright", "Slant", "Flat", "Bevel", "Bench", "Wing");

  private static final List<String> USER_TYPE_NAMES =
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
        faker.address().buildingNumber(),
        generateEntities(MAX_DECEASEDS_FOR_BURIAL, this::generateDeceased));
  }

  public Cemetery generateCemetery() {
    return new Cemetery(
        faker.random().nextLong(),
        cemetery_names.get(faker.random().nextInt(cemetery_names.size())),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber(),
        generateEntities(faker.random().nextInt(MAX_SECTORS_IN_CEMETERY), this::generateSector),
        generateManager(),
        generateEntities(MAX_EMPLOYEES_FOR_CEMETERY, this::generateEmployee));
  }

  public Deceased generateDeceased() {
    return new Deceased(
        faker.random().nextLong(),
        faker.name().firstName(),
        faker.name().lastName(),
        faker.numerify("###########"),
        faker.date().birthday().toInstant(),
        faker.date().birthday().toInstant(),
        new ArrayList<>());
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
        faker.address().buildingNumber(),
        generateInvoice(),
        generateBurial(),
        generateTombstone());
  }

  public Plot generatePlot() {
    return new Plot(
        faker.random().nextLong(),
        faker.random().nextInt(100),
        faker.random().nextInt(100),
        GRAVE_TYPE_NAMES.get(faker.random().nextInt(GRAVE_TYPE_NAMES.size())),
        generateEntities(MAX_DECEASEDS_FOR_PLOT, this::generateDeceased),
        generateEntities(MAX_TOMBSTONES_FOR_PLOT, this::generateTombstone));
  }

  public Reservation generateReservation() {
    return new Reservation(
        faker.random().nextLong(),
        faker.date().birthday().toInstant(),
        faker.address().city(),
        faker.address().streetName(),
        faker.address().buildingNumber(),
        generateEntities(MAX_PLOTS_FOR_RESERVATION, this::generatePlot),
        generateEntities(MAX_PAYMENTS_FOR_USER_AND_RESERVATION, this::generatePayment),
        generateEntities(MAX_BURIALS_FOR_RESERVATION_AND_PAYMENT, this::generateBurial));
  }

  public Sector generateSector() {
    return new Sector(
        faker.random().nextLong(),
        faker.letterify("?"),
        generateEntities(faker.random().nextInt(MAX_PLOTS_IN_SECTOR), this::generatePlot));
  }

  public Tombstone generateTombstone() {
    return new Tombstone(
        faker.random().nextLong(),
        TOMBSTONE_TYPE_NAMES.get(faker.random().nextInt(TOMBSTONE_TYPE_NAMES.size())));
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
        faker.phoneNumber().phoneNumber(),
        generateEntities(MAX_RESERVATIONS_FOR_USER, this::generateReservation),
        generateEntities(MAX_BURIALS_FOR_RESERVATION_AND_PAYMENT, this::generateBurial),
        generateEntities(MAX_PAYMENTS_FOR_USER_AND_RESERVATION, this::generatePayment));
  }

  public Manager generateManager() {
    return new Manager(
        generateUser(), generateEntities(MAX_EXHUMATIONS_FOR_MANAGER, this::generateExhumation));
  }

  public Employee generateEmployee() {
    return new Employee(generateUser());
  }

  public <T> List<T> generateEntities(int numberOfEntities, Supplier<T> generateMethod) {
    var entities = new ArrayList<T>();
    IntStream.range(faker.random().nextInt(numberOfEntities), numberOfEntities)
        .forEach(i -> entities.add(generateMethod.get()));

    return entities;
  }
}
