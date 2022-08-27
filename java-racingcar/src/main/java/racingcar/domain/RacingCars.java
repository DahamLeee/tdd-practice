package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars.addAll(racingCars);
    }

    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public List<RacingCar> move() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomNumberGenerator.generateRacingRandomNumber());
        }
        return unmodifiableList(racingCars);
    }

    public List<RacingCar> winnerOfTheRace() {
        int longestDistance = findLongestDistance();

        return racingCars.stream()
                .filter(racingCar -> racingCar.distance() == longestDistance)
                .collect(Collectors.toUnmodifiableList());
    }

    private int findLongestDistance() {
        return racingCars.stream()
                .mapToInt(RacingCar::distance)
                .max()
                .orElseThrow(() -> new IllegalStateException("가장 긴 거리를 가지는 경주 차를 찾을 수 없습니다."));
    }
}
