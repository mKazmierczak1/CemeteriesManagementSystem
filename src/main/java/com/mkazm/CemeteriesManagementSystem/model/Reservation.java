package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

public record Reservation(
    long id, Instant due_to_date, String city, String street, String number) {}
