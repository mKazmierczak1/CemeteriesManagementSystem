package com.mkazm.CemeteriesManagementSystem.model;

public record User(
    long id,
    String first_name,
    String last_name,
    String city,
    String street,
    String number,
    String email,
    String phone_number) {}
