package nextstep.ladder.application;

import nextstep.ladder.application.dto.LadderCreateRequest;
import nextstep.ladder.application.dto.LadderCreateResponse;
import nextstep.ladder.application.dto.PlayerLadderResultResponse;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

public class LadderService {

    private Players players;
    private LadderGame ladderGame;

    public LadderCreateResponse createLadder(LadderCreateRequest ladderCreateRequest) {
        players = Players.of(ladderCreateRequest.getPlayerNames());

        Ladder ladder = Ladder.of(ladderCreateRequest.getLadderHeight(), players.participatedUserCount());
        LadderResult ladderResult = LadderResult.of(ladderCreateRequest.getLadderResults());
        ladderGame = LadderGame.of(ladder, ladderResult);

        return LadderCreateResponse.of(ladder, ladderResult, ladderCreateRequest.getPlayerNames());
    }

    public void allLadderResult() {

    }

    public PlayerLadderResultResponse ladderResultByPlayerName(String playerName) {
        Player findPlayer = players.findByPlayerName(playerName);
        return PlayerLadderResultResponse.of(ladderGame.ladderResultByPlayer(findPlayer));
    }
}
