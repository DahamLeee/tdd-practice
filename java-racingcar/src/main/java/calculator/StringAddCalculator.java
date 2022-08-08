package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return totalSum(splitText(text));
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

    private static int totalSum(String[] values) {
        int result = 0;

        for (String value : values) {
            PositiveInteger positiveInteger = PositiveInteger.from(value);
            result = positiveInteger.sum(PositiveInteger.from(result));
        }

        return result;
    }
}
