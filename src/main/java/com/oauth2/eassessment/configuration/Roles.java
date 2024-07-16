package com.oauth2.eassessment.configuration;

public enum Roles {

    ADMIN("admin"),
    STUDENT("student"),
    LECTURER("lecurer");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getString() {
        return role;
    }

}
