package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(int racingCarCount) {
        for (int i = 0; i < racingCarCount; i++) {
            racingCars.add(RacingCar.create());
        }
    }

    public void move() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomNumberGenerator.generateRacingRandomNumber());
        }
    }

    public List<RacingCar> getRacingCars() {
        return unmodifiableList(racingCars);
    }
}
