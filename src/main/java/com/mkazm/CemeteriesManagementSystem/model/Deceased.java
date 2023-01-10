package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

public record Deceased(
    long id,
    String first_name,
    String last_name,
    String pesel,
    Instant birth_date,
    Instant death_date) {}
