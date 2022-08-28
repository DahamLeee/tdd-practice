package racingcar.ui;

import racingcar.application.RacingGameService;
import racingcar.application.dto.RacingCarRequest;

public class RacingCarApplication {

    private static final RacingGameService racingGameService = new RacingGameService();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarRequest racingCarRequest = inputView.createRacingRequest();

        ResultView resultView = racingGameService.startRacingGame(racingCarRequest);
        resultView.raceResult();
    }
}
