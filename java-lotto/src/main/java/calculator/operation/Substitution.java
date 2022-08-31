package calculator.operation;

public class Substitution implements ArithmeticOperation {

    private static final String SUBSTITUTION = "-";

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort - rightPort;
    }

    @Override
    public boolean support(String operation) {
        return SUBSTITUTION.equals(operation);
    }
}
