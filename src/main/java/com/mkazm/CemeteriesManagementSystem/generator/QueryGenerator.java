package com.mkazm.CemeteriesManagementSystem.generator;

import com.mkazm.CemeteriesManagementSystem.model.Cemetery;

public class QueryGenerator {

  public String createCemeteryQuery(Cemetery c) {
    return String.format(
        "CREATE (c:Cemetery {name:\"%s\", city:\"%s\", street:\"%s\", number:%s})",
        c.name(), c.city(), c.street(), c.number());
  }
}

// "CREATE (a:Greeting) SET a.message = $message RETURN a.message + ', from node ' + id(a)",
// parameters("message", message)

/*

CREATE (c:Cemetery {name:"Grabiszyn", city:"Wroclaw", street:"Grabiszynska", number:333}) <- [rel:BELONGS_TO] - (sector_a:Sector {name:"A"}),

(plot_1:Plot:Double {row:1, column:1}) - [:PLOT_IS_ON_SECTOR] -> (sector_a),
(plot_2:Plot:Family {row:1, column:2}) - [:PLOT_IS_ON_SECTOR] -> (sector_a),
(plot_3:Plot:Mass {row:2, column:2}) - [:PLOT_IS_ON_SECTOR] -> (sector_a),

(:Tombstone {tombstone_type:"Bench Headstone"}) - [:STANDS_ON] -> (plot_3),

(reservation_2019: Reservation {due_to: date("2019-06-01")}) - [:IS_FOR] -> (plot_1),
(:Reservation {due_to: date("2032-06-01")}) - [:IS_FOR] -> (plot_1),

(payment :Payment {amount: 399.99, datetime: datetime("2018-06-01T18:40:32.142+0100")}) - [:PAYMENT_FOR] -> (reservation_2019),
(:Invoice{city: "Wroclaw", street: "Traugutta", number:"3A/8", company_name:"Spolka z nieograniczona nieodpowiedzialnoscia", NIP:"12345620"}) - [:INVOICE_FOR] -> (payment),

(:Burial {burial_date:date("2022-12-23")}) <- [:BURIED_IN_BURIAL] - (deceased: Deceased {death_date:date("2022-12-19")}),
(plot_2) <- [:BURIED_ON_PLOT] - (deceased),

(kowalski:Deceased {last_name: "Kowalski", death_date: date("1960-1-1")}) - [:BURIED_ON_PLOT] -> (plot_2),

(cemetery_manager: User:Manager{first_name: "Nowak", last_name: "Jan", city: "Wroclaw", street: "Kochanowskiego", number: "1A/7", email: "jNowak@gmail.com", phone_number: "+48 22 444 44 44"}) - [:MANAGES] -> (c),
(exhumation: Exhumation {exhumation_date: date("2016-02-29"), reason: "On prosecutor's demand"}),
(exhumation) - [:ORDERED_BY] -> (cemetery_manager),
(exhumation) - [:EXECUTED_ON] -> (kowalski)
 */
