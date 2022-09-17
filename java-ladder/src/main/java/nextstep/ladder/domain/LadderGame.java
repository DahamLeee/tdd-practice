package nextstep.ladder.domain;

public class LadderGame {

    private final Ladder ladder;
    private final LadderResult ladderResult;

    private LadderGame(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public static LadderGame of(Ladder ladder, LadderResult ladderResult) {
        return new LadderGame(ladder, ladderResult);
    }

    public String ladderResultByStartColumn(int startColumn) {
        int endColumn = ladder.climb(startColumn);
        return ladderResult.ladderResultByEndColumn(endColumn);
    }
}
