package nextstep.ladder.application.dto;

import nextstep.ladder.domain.PlayerLadderResult;

public class PlayerLadderResultResponse {

    private final String playerName;
    private final String ladderResult;

    private PlayerLadderResultResponse(String playerName, String ladderResult) {
        this.playerName = playerName;
        this.ladderResult = ladderResult;
    }

    public static PlayerLadderResultResponse of(PlayerLadderResult ladderResultByPlayer) {
        return new PlayerLadderResultResponse(ladderResultByPlayer.getPlayerName(), ladderResultByPlayer.getLadderResult());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getLadderResult() {
        return ladderResult;
    }
}
