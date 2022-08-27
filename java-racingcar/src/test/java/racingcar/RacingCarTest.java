package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    public void move(int randomNumber, int distance) {
        RacingCar racingCar = RacingCar.from(RacingCarName.from("blue"));
        racingCar.move(randomNumber);

        assertThat(racingCar.distance()).isEqualTo(distance);
    }

}