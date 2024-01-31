package com.exercises.easy.schedule;

public class Contact {

    private final String name;
    private final String phoneNumber;
    private final String email;

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", name, email, phoneNumber);
    }
}
