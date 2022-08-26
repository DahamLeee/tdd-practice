package racingcar.domain;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(int racingCarCount) {
        this.racingCars = new RacingCars(racingCarCount);
    }

    public RacingCars raceStart() {
        racingCars.move();
        return racingCars;
    }
}
