package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

public record Burial(long id, Instant burial_date, String city, String street, String number) {}
