package com.mkazm.CemeteriesManagementSystem;

import com.mkazm.CemeteriesManagementSystem.repository.CemeteryRepository;
import com.mkazm.CemeteriesManagementSystem.repository.Neo4jDao;
import com.mkazm.CemeteriesManagementSystem.repository.ReservationRepository;
import com.mkazm.CemeteriesManagementSystem.generator.ModelGenerator;
import com.mkazm.CemeteriesManagementSystem.generator.QueryGenerator;
import com.mkazm.CemeteriesManagementSystem.model.*;
import java.util.Collection;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

  private final Neo4jDao dao;
  private final QueryGenerator queryGenerator;
  private final ModelGenerator modelGenerator;
  private final CemeteryRepository cemeteryRepository;
  private final ReservationRepository reservationRepository;
  private final Random random = new Random();

  @Override
  public void run(ApplicationArguments args) {
    var cemetery = modelGenerator.generateCemetery();
    var reservations = modelGenerator.generateEntities(10, modelGenerator::generateReservation);
    var query = queryGenerator.createCemeteryQuery(cemetery);

    addPlotsFromReservationsToCemetery(reservations, cemetery);

    System.out.println("Started inserting: " + cemetery);
    System.out.println("Query: " + query);

    cemeteryRepository.save(cemetery);
    reservationRepository.saveAll(reservations);


    System.out.println("Insert completed!");
  }

  void addPlotsFromReservationsToCemetery(Collection<Reservation> reservations, Cemetery cemetery) {
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
}
