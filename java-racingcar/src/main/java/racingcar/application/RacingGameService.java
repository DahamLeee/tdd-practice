package racingcar.application;

import racingcar.application.dto.RacingRequest;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.ui.ResultView;

public class RacingGameService {

    public ResultView startRacingGame(RacingRequest racingRequest) {
        RacingGame racingGame = new RacingGame(racingRequest.getRacingCarCount());
        ResultView resultView = new ResultView();

        for (int i = 0; i < racingRequest.getMoveCount(); i++) {
            RacingCars racingCars = racingGame.raceStart();
            resultView.drawRoundDistance(racingCars.getRacingCars());
        }

        return resultView;
    }
}
