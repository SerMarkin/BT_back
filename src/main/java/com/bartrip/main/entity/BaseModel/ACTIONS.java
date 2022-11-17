package com.bartrip.main.entity.BaseModel;

public enum ACTIONS {

    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String name;

    private ACTIONS(String value) {
        this.name = value;
    }

    public String value() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
