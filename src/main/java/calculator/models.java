package calculator;

public class models {
    public abstract static class Binaryoperations implements interfaces.Binaryoperation{
        private final String name;
        public Binaryoperations(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        @Override
        public abstract int apply(int a,int b);
    }

    public static class Addition extends Binaryoperations{
        public Addition() {super("Addition");}
        @Override
        public int apply(int a,int b){
            return Math.addExact(a,b);
        }
    }

    public static class Subtraction extends Binaryoperations{
        public Subtraction() {super("Subtraction");}
        @Override
        public int apply(int a,int b){
            return Math.subtractExact(a,b);
        }
    }

    public static class Multiplication extends Binaryoperations{
        public Multiplication() {super("Multiplication");}
        @Override
        public int apply(int a,int b){
            return Math.multiplyExact(a,b);
        }
    }

    public static class Division extends Binaryoperations{
        public Division() {super("Division");}
        @Override
        public int apply(int a,int b){
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a/b;
        }
    }
}
