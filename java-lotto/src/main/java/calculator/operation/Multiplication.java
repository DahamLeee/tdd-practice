package calculator.operation;

public class Multiplication implements ArithmeticOperation {

    private static final String MULTIPLICATION = "*";

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort * rightPort;
    }

    @Override
    public boolean support(String operation) {
        return MULTIPLICATION.equals(operation);
    }
}
