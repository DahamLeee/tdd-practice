package racingcar.application.dto;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class RoundResult {

    private List<RacingCarResponse> racingCarResponses;

    private RoundResult() { }

    private RoundResult(List<RacingCarResponse> racingCarResponses) {
        this.racingCarResponses = racingCarResponses;
    }

    public static RoundResult of(List<RacingCarResponse> racingCarResponses) {
        return new RoundResult(racingCarResponses);
    }

    public List<RacingCarResponse> getRacingCarResponses() {
        return unmodifiableList(racingCarResponses);
    }
}
