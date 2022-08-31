package calculator.operation;

public class Addition implements ArithmeticOperation{

    private static final String ADDITION = "+";

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort + rightPort;
    }

    @Override
    public boolean support(String operation) {
        return ADDITION.equals(operation);
    }
}
