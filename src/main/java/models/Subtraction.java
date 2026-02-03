package models;

public class Subtraction extends Binaryoperations {
    public Subtraction() {
        super("Subtraction");
    }

    @Override
    public int apply(int a, int b) {
        return Math.subtractExact(a, b);
    }
}