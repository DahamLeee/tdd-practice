package racingcar.ui;

import racingcar.domain.RacingCar;
import racingcar.application.dto.RoundResult;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_MARK = "-";

    private final List<RoundResult> roundResults;
    private final List<RacingCar> winners;

    public ResultView(List<RoundResult> roundResults, List<RacingCar> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public void raceResult() {
        roundResults.forEach(roundResult -> {
            roundResult.getRacingCarResponses().forEach(racingCarResponse -> {
                System.out.printf("%s : %s \n", racingCarResponse.getRacingCarName(), printDistanceToMark(racingCarResponse.getDistance()));
            });
            System.out.println();
        });

        winners.forEach(winner -> System.out.printf(winner.carName() + " "));
        System.out.println("가 최종 우승했습니다.");
    }

    private String printDistanceToMark(int distance) {
        return DISTANCE_MARK.repeat(Math.max(0, distance));
    }
}
