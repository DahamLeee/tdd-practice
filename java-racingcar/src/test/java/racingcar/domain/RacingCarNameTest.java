package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarNameTest {

    @Test
    void createRacingCarName() {
        String racingCarName = "blue";
        assertThat(RacingCarName.from(racingCarName).racingCarName()).isEqualTo(racingCarName);
    }

    @Test
    void maxLengthRacingCarNameException() {
        String racingCarName = "orange";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarName.from(racingCarName))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다 *(입력하신 이름 : %s)", racingCarName);
    }
}