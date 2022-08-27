package racingcar.application.dto;

public class RacingCarResponse {

    private String racingCarName;
    private int distance;

    private RacingCarResponse() { }

    private RacingCarResponse(String racingCarName, int distance) {
        this.racingCarName = racingCarName;
        this.distance = distance;
    }

    public static RacingCarResponse of(String racingCarName, int distance) {
        return new RacingCarResponse(racingCarName, distance);
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public int getDistance() {
        return distance;
    }
}
