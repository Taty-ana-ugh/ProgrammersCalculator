package models;

import calculator.interfaces.Binaryoperation;

public abstract class Binaryoperations implements Binaryoperation {
    private final String name;

    public Binaryoperations(String name) {
        this.name = name;
    }

    @Override
    public abstract int apply(int a, int b);
}