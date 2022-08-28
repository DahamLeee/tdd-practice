package racingcar.application.dto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class RacingCarRequest {

    private final List<String> racingCarNames = new ArrayList<>();
    private final int moveCount;

    private RacingCarRequest() {
        this.moveCount = 0;
    }

    private RacingCarRequest(List<String> racingCarNames, int moveCount) {
        this.racingCarNames.addAll(racingCarNames);
        this.moveCount = moveCount;
    }

    public static RacingCarRequest of(List<String> racingCarNames, int moveCount) {
        return new RacingCarRequest(racingCarNames, moveCount);
    }

    public List<String> getRacingCarNames() {
        return unmodifiableList(racingCarNames);
    }

    public int getMoveCount() {
        return moveCount;
    }
}
