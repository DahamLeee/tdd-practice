package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String BLANK_REGEX = " ";

    public static int calculate(String source) {
        validateNullOrEmpty(source);
        List<String> ports = splitSource(source);
        return 0;
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
