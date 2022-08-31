package calculator.operation;

public interface ArithmeticOperation {

    int calculate(int leftPort, int rightPort);

    boolean support(String operation);
}
