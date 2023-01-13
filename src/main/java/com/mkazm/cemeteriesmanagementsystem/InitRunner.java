package com.mkazm.cemeteriesmanagementsystem;

import com.mkazm.cemeteriesmanagementsystem.generator.ModelGenerator;
import com.mkazm.cemeteriesmanagementsystem.model.*;
import com.mkazm.cemeteriesmanagementsystem.repository.CemeteryRepository;
import com.mkazm.cemeteriesmanagementsystem.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

  private final ModelGenerator modelGenerator;
  private final CemeteryRepository cemeteryRepository;
  private final UserRepository userRepository;
  private final Random random = new Random();

  private static final int ITERATIONS_NUMBER = 1;
  private static final int MAX_USERS = 5;

  @Override
  public void run(ApplicationArguments args) throws InterruptedException {
    for (int i = 1; i <= ITERATIONS_NUMBER; i++) {
      var cemetery = modelGenerator.generateCemetery();
      var users = modelGenerator.generateEntities(MAX_USERS, modelGenerator::generateUser);
      var reservations = getAllReservations(users);
      var payments = getAllPayments(users, reservations);

      addPlotsFromReservationsToCemetery(reservations, cemetery);

      var plots = getAllPlots(cemetery);

      addBuriedToPlots(getAllBuried(payments, reservations), plots);
      addDeceasedsToExhumations(getAllDeceaseds(plots), cemetery.manager().getExhumations());
      addTombstonesToPayments(payments, plots);

      log.info("Started inserting. Iteration: {}", i);

      var queryResult = CompletableFuture.runAsync(() -> {
        cemeteryRepository.save(cemetery);
        userRepository.saveAll(users);
      });

      while (!queryResult.isDone()) {
        log.info("Still inserting data...");
        Thread.sleep(5000);
      }

      log.info("Insert completed!");
    }
  }

  private List<Reservation> getAllReservations(Collection<User> users) {
    return users.stream().flatMap(user -> user.getReservations().stream()).toList();
  }

  private List<Plot> getAllPlots(Cemetery cemetery) {
    return cemetery.sectors().stream().flatMap(sector -> sector.plots().stream()).toList();
  }

  private List<Deceased> getAllDeceaseds(Collection<Plot> plots) {
    return plots.stream().flatMap(plot -> plot.deceaseds().stream()).toList();
  }

  private List<Payment> getAllPayments(
      Collection<User> users, Collection<Reservation> reservations) {
    return Stream.concat(
            users.stream().flatMap(user -> user.getPayments().stream()),
            reservations.stream().flatMap(reservation -> reservation.payments().stream()))
        .toList();
  }

  private List<Deceased> getAllBuried(
      Collection<Payment> payments, Collection<Reservation> reservations) {
    return Stream.concat(
            payments.stream().flatMap(payment -> Stream.of(payment.burial())),
            reservations.stream().flatMap(reservation -> reservation.burials().stream()))
        .flatMap(burial -> burial.deceaseds().stream())
        .toList();
  }

  private void addPlotsFromReservationsToCemetery(
      Collection<Reservation> reservations, Cemetery cemetery) {
    reservations.forEach(
        reservation ->
            reservation
                .plots()
                .forEach(
                    plot ->
                        cemetery
                            .getSector(random.nextInt(cemetery.getSectorsSize()))
                            .addPlot(plot)));
  }

  private void addDeceasedsToExhumations(
      Collection<Deceased> deceaseds, List<Exhumation> exhumations) {
    deceaseds.stream()
        .limit(deceaseds.size() / 2)
        .forEach(deceased -> deceased.exhumations().add(getRandomElement(exhumations)));
  }

  private void addTombstonesToPayments(Collection<Payment> payments, List<Plot> plots) {
    payments.forEach(payment -> getRandomElement(plots).tombstones().add(payment.tombstone()));
  }

  private void addBuriedToPlots(Collection<Deceased> buried, List<Plot> plots) {
    buried.forEach(deceased -> getRandomElement(plots).deceaseds().add(deceased));
  }

  private <T> T getRandomElement(List<T> elements) {
    return elements.get(random.nextInt(elements.isEmpty() ? 1 : elements.size()));
  }
}
