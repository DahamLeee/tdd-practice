package nextstep.ladder.application.dto;

import java.util.ArrayList;
import java.util.List;

public class LadderCreateRequest {

    private final List<String> playerNames = new ArrayList<>();
    private final int ladderHeight;

    private LadderCreateRequest(List<String> playerNames, int ladderHeight) {
        this.playerNames.addAll(playerNames);
        this.ladderHeight = ladderHeight;
    }

    public static LadderCreateRequest of(List<String> playerNames, int ladderHeight) {
        return new LadderCreateRequest(playerNames, ladderHeight);
    }

    @Override
    public String toString() {
        return "LadderCreateRequest{" +
                "playerNames=" + playerNames +
                ", ladderHeight=" + ladderHeight +
                '}';
    }
}
