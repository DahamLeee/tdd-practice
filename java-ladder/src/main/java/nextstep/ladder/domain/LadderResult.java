package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResult {

    private final List<String> ladderResults;

    private LadderResult(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResult of(List<String> ladderResults) {
        return new LadderResult(ladderResults);
    }

    public String ladderResultByEndColumn(int endColumn) {
        return this.ladderResults.get(endColumn);
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
