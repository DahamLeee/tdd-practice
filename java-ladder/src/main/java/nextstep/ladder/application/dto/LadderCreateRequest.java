package nextstep.ladder.application.dto;

import java.util.Collections;
import java.util.List;

public class LadderCreateRequest {

    private final List<String> playerNames;
    private final List<String> ladderResults;
    private final int ladderHeight;

    private LadderCreateRequest(List<String> playerNames, List<String> ladderResults, int ladderHeight) {
        this.playerNames = playerNames;
        this.ladderResults = ladderResults;
        this.ladderHeight = ladderHeight;
    }

    public static LadderCreateRequest of(List<String> playerNames, List<String> ladderResults, int ladderHeight) {
        return new LadderCreateRequest(playerNames, ladderResults, ladderHeight);
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
