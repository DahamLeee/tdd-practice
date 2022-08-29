package calculator.operation;

public class Multiplication implements ArithmeticOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort * rightPort;
    }
}
