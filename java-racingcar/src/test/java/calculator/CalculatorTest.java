package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("빈 문자열이거나 null 일 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void whenNullOrEmptyString(String value) {
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력할 경우")
    @Test
    void onlyOneNumber() {
        assertThat(StringAddCalculator.splitAndSum("1")).isOne();
    }

    @Test
    @DisplayName("쉼표 구분자")
    void restSplitter() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론 구분자")
    void colonSplitter() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표, 콜론 구분자")
    void restAndColonSplitter() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    void customSplitter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    @DisplayName("문자에 음수가 있을 경우 예외")
    void negativeNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2:3"));
    }

    @Test
    @DisplayName("커스텀 구분자에 음수가 있을 경우 예외")
    void customSplitterAndNegativeNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;2,3"));
    }
}
