package com.example.magicdoc.data.operations;

public enum OperationTypes {
    RETAIN("retain"),
    INSERT("insert"),
    DELETE("delete");
    private final String customString;

    OperationTypes(String customString) {
        this.customString = customString;
    }

    @Override
    public String toString() {
        return customString;
    }

}
