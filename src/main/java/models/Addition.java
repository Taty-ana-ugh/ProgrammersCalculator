package models;

public class Addition extends Binaryoperations {
    public Addition() {
        super("Addition");
    }

    @Override
    public int apply(int a, int b) {
        return Math.addExact(a, b);
    }
}