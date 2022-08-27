package racingcar.domain;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(int racingCarCount) {
        this.racingCars = RacingCars.from(racingCarCount);
    }

    public RacingCars raceStart() {
        racingCars.move();
        return racingCars;
    }
}
