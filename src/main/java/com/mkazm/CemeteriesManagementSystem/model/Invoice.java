package com.mkazm.CemeteriesManagementSystem.model;

public record Invoice(
    long id, String city, String street, String number, String nip, String company_name) {}
