package calculator.operation;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperationFactory {

    private static final List<ArithmeticOperation> operations = new ArrayList<>();

    public ArithmeticOperationFactory() {
        operations.add(new Addition());
        operations.add(new Substitution());
        operations.add(new Multiplication());
        operations.add(new Division());
    }

    public ArithmeticOperation findOperation(String operation) {
        return operations.stream()
                .filter(arithmeticOperation -> arithmeticOperation.support(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("적절한 사칙연산이 들어오지 않았습니다."));
    }
}
