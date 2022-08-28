package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @DisplayName("레이싱 경주 우승자 구하기")
    @Test
    void winnerOfTheRacingCar() {
        RacingCars racingCars = RacingCars.of(
                List.of(
                        RacingCar.of(RacingCarName.from("a"), Distance.from(3)),
                        RacingCar.of(RacingCarName.from("b"), Distance.from(4)),
                        RacingCar.of(RacingCarName.from("c"), Distance.from(5))));

        List<RacingCar> winners = racingCars.winnerOfTheRace();

        assertAll(
                () -> assertThat(winners).hasSize(1),
                () -> assertThat(winners).extracting("distance").containsExactly(5)
        );
    }
}