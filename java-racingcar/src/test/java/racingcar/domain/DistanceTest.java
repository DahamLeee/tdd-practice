package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    @DisplayName("음수로 거리 값 예외")
    @Test
    void negativeDistanceException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Distance.from(-1))
                .withMessage("거리는 음수일 수 없습니다. *(입력한 거리 %s)", -1);
    }

}