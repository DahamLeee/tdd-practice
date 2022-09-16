package nextstep.ladder.application;

import nextstep.ladder.application.dto.LadderCreateRequest;
import nextstep.ladder.application.dto.LadderCreateResponse;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;

public class LadderService {

    private Players players;

    public LadderCreateResponse createLadder(LadderCreateRequest ladderCreateRequest) {
        players = Players.of(ladderCreateRequest.getPlayerNames());
        Ladder ladder = Ladder.of(ladderCreateRequest.getLadderHeight(), players.participatedUserCount());

        return LadderCreateResponse.of(ladder, ladderCreateRequest.getPlayerNames());
    }
}
