package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

public record Payment(
    long id, double amount, Instant datetime, String city, String street, int number) {}
