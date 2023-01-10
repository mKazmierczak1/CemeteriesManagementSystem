package com.mkazm.CemeteriesManagementSystem.model;

public record User(
    long id,
    String first_name,
    String last_name,
    String city,
    String street,
    int number,
    String email,
    String phone_number) {}
