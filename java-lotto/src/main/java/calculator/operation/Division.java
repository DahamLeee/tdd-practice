package calculator.operation;

public class Division implements ArithmeticOperation {

    private static final String DIVISION = "/";

    @Override
    public int calculate(int leftPort, int rightPort) {
        if (rightPort == 0) {
            throw new IllegalArgumentException("0으로 나눌 수는 없습니다.");
        }
        return leftPort / rightPort;
    }

    @Override
    public boolean support(String operation) {
        return DIVISION.equals(operation);
    }
}
