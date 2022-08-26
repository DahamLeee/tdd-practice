package racingcar.application.dto;

public class RacingRequest {

    private final int racingCarCount;
    private final int moveCount;

    public RacingRequest(int racingCarCount, int moveCount) {
        this.racingCarCount = racingCarCount;
        this.moveCount = moveCount;
    }

    public int getRacingCarCount() {
        return racingCarCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
