package com.mkazm.CemeteriesManagementSystem.model;

import java.time.Instant;

public record Exhumation(long id, Instant exhumation_date, String reason) {}
