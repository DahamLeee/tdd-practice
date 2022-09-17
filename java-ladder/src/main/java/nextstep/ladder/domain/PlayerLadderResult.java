package nextstep.ladder.domain;

public class PlayerLadderResult {

    private final String playerName;
    private final String ladderResult;

    private PlayerLadderResult(String playerName, String ladderResult) {
        this.playerName = playerName;
        this.ladderResult = ladderResult;
    }

    public static PlayerLadderResult of(String playerName, String ladderResult) {
        return new PlayerLadderResult(playerName, ladderResult);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getLadderResult() {
        return ladderResult;
    }
}
