package models;

public class Multiplication extends Binaryoperations {
    public Multiplication() {
        super("Multiplication");
    }

    @Override
    public int apply(int a, int b) {
        return Math.multiplyExact(a, b);
    }
}