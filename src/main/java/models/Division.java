package models;

public class Division extends Binaryoperations {
    public Division() {
        super("Division");
    }

    @Override
    public int apply(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}