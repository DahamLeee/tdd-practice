package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @ParameterizedTest(name = "첫 번째 지점은 왼쪽 이동이 불가능하다.")
    @CsvSource(value = {"true:true", "false:false"}, delimiter = ':')
    void firstPointTest(boolean right, boolean expectedRight) {
        Direction firstDirection = Direction.first(right);
        assertThat(firstDirection.isLeft()).isFalse();
        assertThat(firstDirection.isRight()).isEqualTo(expectedRight);
    }

    @Test
    @DisplayName("한 지점에서 왼쪽, 오른쪽 방향으로 가는 경우 예외")
    void invalidDirection() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Direction.of(true, true)
        ).withMessage("한 지점에서 양방향 이동이 존재할 수는 없습니다.");
    }
}