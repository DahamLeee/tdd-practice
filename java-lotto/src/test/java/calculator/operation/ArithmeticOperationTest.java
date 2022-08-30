package calculator.operation;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticOperationTest {

    @DisplayName("'좌항 덧셈 우항'을 나타내는 문자열을 계산한다.")
    @Test
    void calculatePlus() {
        String given = "3 + 5";

        int result = StringCalculator.calculate(given);

        assertThat(result).isEqualTo(8);
    }
}