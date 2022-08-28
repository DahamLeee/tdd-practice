package racingcar.application.dto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class RacingCarRequest {

    private final List<String> racingCarNames = new ArrayList<>();
    private final int moveCount;

    public RacingCarRequest(List<String> racingCarNames, int moveCount) {
        this.racingCarNames.addAll(racingCarNames);
        this.moveCount = moveCount;
    }

    public List<String> getRacingCarNames() {
        return unmodifiableList(racingCarNames);
    }

    public int getMoveCount() {
        return moveCount;
    }
}
