package nextstep.ladder.application.dto;

import nextstep.ladder.domain.LadderResult;

import java.util.Collections;
import java.util.List;

public class LadderResultDto {

    private final List<String> ladderResults;

    private LadderResultDto(LadderResult ladderResult) {
        this.ladderResults = ladderResult.getLadderResults();
    }

    public static LadderResultDto from(LadderResult ladderResult) {
        return new LadderResultDto(ladderResult);
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
