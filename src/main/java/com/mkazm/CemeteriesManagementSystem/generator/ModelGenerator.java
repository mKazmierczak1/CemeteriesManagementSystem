package com.mkazm.CemeteriesManagementSystem.generator;

import com.github.javafaker.Faker;
import com.mkazm.CemeteriesManagementSystem.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ModelGenerator {

  private final Faker faker;

  private static final int maxBurialBatchCount = 400;
  private static final int maxCemeteryBatchCount = 1;
  private static final int maxDeceasedBatchCount = 1000;
  private static final int maxExhumationBatchCount = 100;
  private static final int MAX_PLOTS_IN_SECTOR = 50;
  private static final int MAX_PLOTS_FOR_RESERVATION = 5;
  private static final int maxReservationBatchCount = 800;
  private static final int MAX_SECTORS_IN_CEMETERY = 10;
  private static final int maxTombstoneBatchCount = 800;
  private static final int maxUserBatchCount = 200;

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
        faker.address().buildingNumber(),
        generateEntities(faker.random().nextInt(MAX_SECTORS_IN_CEMETERY), this::generateSector),
        new Manager(generateUser()));
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
        faker.address().buildingNumber(),
        generateEntities(MAX_PLOTS_FOR_RESERVATION, this::generatePlot));
  }

  public Sector generateSector() {
    return new Sector(
        faker.random().nextLong(),
        faker.letterify("?"),
        generateEntities(faker.random().nextInt(MAX_PLOTS_IN_SECTOR), this::generatePlot));
  }

  public Tombstone generateTombstone() {
    return new Tombstone(
        faker.random().nextLong());
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
        List.of());
  }

  public <T> List<T> generateEntities(int numberOfEntities, Supplier<T> generateMethod) {
    var entities = new ArrayList<T>();
    IntStream.range(0, numberOfEntities).forEach(i -> entities.add(generateMethod.get()));

    return entities;
  }
}
