package nextstep.ladder;

import nextstep.ladder.application.LadderService;
import nextstep.ladder.application.dto.LadderCreateRequest;
import nextstep.ladder.application.dto.LadderCreateResponse;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final LadderService ladderService = new LadderService();

    public static void main(String[] args) {
        LadderCreateResponse ladderCreateResponse = requestCreateLadderAPI();
        resultView.printLadderResponseView(ladderCreateResponse);

        requestLadderResultAPI();
    }

    private static void requestLadderResultAPI() {
        while (true) {
            String playerName = inputView.playerNameForLadderResult();

            if (playerName.equals("all")) {
                ladderService.allLadderResult();
                break;
            }

            String ladderResult = ladderService.ladderResultByPlayerName(playerName);
            inputView.printLadderResultView(ladderResult);
        }
    }

    private static LadderCreateResponse requestCreateLadderAPI() {
        LadderCreateRequest ladderCreateRequest = inputView.requestLadder();
        return ladderService.createLadder(ladderCreateRequest);
    }
}
