package calculator;

import calculator.operation.ArithmeticOperation;
import calculator.operation.ArithmeticOperationFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String BLANK_REGEX = " ";

    public static int calculate(String source) {
        validateNullOrEmpty(source);
        List<String> ports = splitSource(source);

        int leftPort = Integer.parseInt(ports.get(0));

        for (int i = 1; i < ports.size(); i += 2) {
            int rightPort = Integer.parseInt(ports.get(i + 1));
            leftPort = calculateByOperation(leftPort, ports.get(i), rightPort);
        }

        return leftPort;
    }

    private static int calculateByOperation(int leftPort, String operation, int rightPort) {
        ArithmeticOperationFactory operationFactory = new ArithmeticOperationFactory();
        ArithmeticOperation arithmeticOperation = operationFactory.findOperation(operation);

        return arithmeticOperation.calculate(leftPort, rightPort);
    }

    private static List<String> splitSource(String source) {
        return Arrays.stream(source.split(BLANK_REGEX))
                .collect(Collectors.toList());
    }

    private static void validateNullOrEmpty(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("계산하려는 문자열은 null 혹은 공백일 수 없습니다.");
        }
    }
}
