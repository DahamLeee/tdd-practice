package calculator.operation;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ArithmeticOperationTest {

    @DisplayName("'좌항 덧셈 우항'을 나타내는 문자열을 계산한다.")
    @Test
    void calculatePlus() {
        String source = "3 + 5";

        int result = StringCalculator.calculate(source);

        assertThat(result).isEqualTo(8);
    }

    @DisplayName("'좌항 뺄셈 우항'을 나타내는 문자열을 계산한다.")
    @Test
    void calculateSubstitution() {
        String source = "5 - 3";

        int result = StringCalculator.calculate(source);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("'좌항 곱셈 우항'을 나타내는 문자열을 계산한다.")
    @Test
    void calculateMultiplication() {
        String source = "3 * 5";

        int result = StringCalculator.calculate(source);

        assertThat(result).isEqualTo(15);
    }

    @DisplayName("'좌항 나누기 우항'을 나타내는 문자열을 계산한다.")
    @Test
    void calculateDivision() {
        String source = "8 / 4";

        int result = StringCalculator.calculate(source);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("'좌항 나누기 우항'에서 우항이 0일 경우 예외 처리")
    @Test
    void divideZeroException() {
        String source = "8 / 0";

        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(source))
                .withMessage("0으로 나눌 수는 없습니다.");
    }

    @DisplayName("복합적인 연산 수행")
    @Test
    void calculateCombinedOperation() {
        String source = "2 + 3 * 4 / 2";

        int result = StringCalculator.calculate(source);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("빈 문자열 혹은 공백이 들어왔을 경우 예외")
    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmptyString(String source) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(source))
                .withMessage("계산하려는 문자열은 null 혹은 공백일 수 없습니다.");
    }

    @DisplayName("문자열에 적절하지 않은 연산이 들어왔을 경우 예외")
    @Test
    void invalidOperationException() {
        String given = "3 & 5";

        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(given))
                .withMessage("적절한 사칙연산이 들어오지 않았습니다. 입력된 연산 %s", "&");
    }
}