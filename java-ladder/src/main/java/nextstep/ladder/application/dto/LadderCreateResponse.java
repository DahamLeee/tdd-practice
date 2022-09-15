package nextstep.ladder.application.dto;

import nextstep.ladder.domain.Ladder;

import java.util.Collections;
import java.util.List;

public class LadderCreateResponse {

    private final LadderDto ladderDto;
    private final List<String> playerNames;

    private LadderCreateResponse(Ladder ladder, List<String> playerNames) {
        this.ladderDto = LadderDto.from(ladder);
        this.playerNames = playerNames;
    }

    public static LadderCreateResponse of(Ladder ladder, List<String> playerNames) {
        return new LadderCreateResponse(ladder, playerNames);
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
