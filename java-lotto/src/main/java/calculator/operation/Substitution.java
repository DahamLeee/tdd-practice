package calculator.operation;

public class Substitution implements ArithmeticOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort - rightPort;
    }
}
