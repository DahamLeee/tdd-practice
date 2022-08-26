package racingcar.ui;

import racingcar.application.RacingGameService;
import racingcar.application.dto.RacingRequest;

public class RacingCarApplication {

    private static final RacingGameService racingGameService = new RacingGameService();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingRequest racingRequest = inputView.createRacingRequest();

        ResultView resultView = racingGameService.startRacingGame(racingRequest);
        resultView.raceResult();
    }
}
