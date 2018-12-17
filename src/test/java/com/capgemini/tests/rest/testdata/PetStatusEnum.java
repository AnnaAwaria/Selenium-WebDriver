package com.capgemini.tests.rest.testdata;

public enum PetStatusEnum {

    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String status;

    PetStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
