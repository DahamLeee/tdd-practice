package nextstep.ladder.application;

import nextstep.ladder.application.dto.LadderCreateRequest;
import nextstep.ladder.application.dto.LadderCreateResponse;
import nextstep.ladder.domain.Ladder;

public class LadderService {

    public LadderCreateResponse createLadder(LadderCreateRequest ladderCreateRequest) {
        Ladder ladder = Ladder.of(ladderCreateRequest.getLadderHeight(), ladderCreateRequest.getPlayerNames().size());
        return LadderCreateResponse.of(ladder, ladderCreateRequest.getPlayerNames());
    }
}
