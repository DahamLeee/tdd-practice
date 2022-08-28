package racingcar.application;

import racingcar.application.dto.RacingCarResponse;
import racingcar.application.dto.RacingCarRequest;
import racingcar.application.dto.RoundResult;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingGameService {

    public ResultView startRacingGame(RacingCarRequest racingCarRequest) {
        List<RoundResult> roundResults = new ArrayList<>();
        RacingCars racingCars = RacingCars.of(toRacingCars(racingCarRequest.getRacingCarNames()));

        for (int i = 0; i < racingCarRequest.getMoveCount(); i++) {
            roundResults.add(recordRoundResults(racingCars.move()));
        }

        return new ResultView(roundResults, racingCars.winnerOfTheRace());
    }

    private List<RacingCar> toRacingCars(List<String> racingCarNames) {
        return racingCarNames.stream()
                .map(RacingCarName::from)
                .map(RacingCar::from)
                .collect(toList());
    }

    private RoundResult recordRoundResults(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(racingCar -> RacingCarResponse.of(racingCar.carName(), racingCar.distance()))
                .collect(collectingAndThen(toList(), RoundResult::of));
    }
}
