package com.mkazm.CemeteriesManagementSystem.model;

public record Invoice(
    long id, String city, String street, int number, String nip, String company_name) {}
