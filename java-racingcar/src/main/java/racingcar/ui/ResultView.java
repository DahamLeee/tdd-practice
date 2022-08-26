package racingcar.ui;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private final List<String> roundResults = new ArrayList<>();

    public void drawRoundDistance(List<RacingCar> racingCars) {
        StringBuilder roundResultBuilder = new StringBuilder();

        for (RacingCar racingCar : racingCars) {
            roundResultBuilder.append(racingCar.distanceToString()).append("\n");
        }
        roundResults.add(roundResultBuilder.append("\n").toString());
    }

    public void raceResult() {
        roundResults.forEach(System.out::println);
    }

}
