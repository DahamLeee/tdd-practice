package nextstep.ladder.application.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;

import java.util.Collections;
import java.util.List;

public class LadderCreateResponse {

    private final LadderDto ladderDto;
    private final LadderResultDto ladderResultDto;
    private final List<String> playerNames;

    private LadderCreateResponse(Ladder ladder, LadderResult ladderResult, List<String> playerNames) {
        this.ladderDto = LadderDto.from(ladder);
        this.ladderResultDto = LadderResultDto.from(ladderResult);
        this.playerNames = playerNames;
    }

    public static LadderCreateResponse of(Ladder ladder, LadderResult ladderResult, List<String> playerNames) {
        return new LadderCreateResponse(ladder, ladderResult, playerNames);
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public LadderResultDto getLadderResultDto() {
        return ladderResultDto;
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
