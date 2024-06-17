package com.main.enums;

public enum Status {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), UNASSIGNED("UNASSIGNED"),
    ASSIGNED("ASSIGNED"), BLOCKED("BLOCKED"), DELETED("DELETED"),
    SUCCESS("SUCCESS"), FAILED("FAILED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static Status getEnum(String value) {

        if (value == null)
            throw new IllegalArgumentException();
        for (Status v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }
}
