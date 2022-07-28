package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        String[] values = splitText(text);

        return sumText(values);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitText(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int sumText(String[] values) {
        validateNegativeNumber(values);
        return sumStringArray(values);
    }

    private static void validateNegativeNumber(String[] values) {
        if (matchNegativeNumber(values)) {
            throw new IllegalArgumentException("음수는 올 수 없습니다.");
        }
    }

    private static boolean matchNegativeNumber(String[] values) {
        return Arrays.stream(values)
                .map(Integer::parseInt)
                .anyMatch(integer -> integer < 0);
    }

    private static int sumStringArray(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
