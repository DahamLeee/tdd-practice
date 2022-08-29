package calculator.operation;

public class Addition implements ArithmeticOperation{

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort + rightPort;
    }
}
