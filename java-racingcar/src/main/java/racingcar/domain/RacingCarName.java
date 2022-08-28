package racingcar.domain;

public class RacingCarName {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private String racingCarName;

    protected RacingCarName() { }

    private RacingCarName(String racingCarName) {
        validateNameLength(racingCarName);
        this.racingCarName = racingCarName;
    }

    private void validateNameLength(String racingCarName) {
        if (racingCarName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 5자를 초과할 수 없습니다 *(입력하신 이름 : %s)", racingCarName));
        }
    }

    public static RacingCarName from(String racingCarName) {
        return new RacingCarName(racingCarName);
    }

    public String racingCarName() {
        return racingCarName;
    }
}
