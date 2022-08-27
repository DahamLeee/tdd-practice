package racingcar.domain;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    private static final String DISTANCE_MARK = "-";

    private RacingCarName racingCarName;
    private int distance;

    private RacingCar() { }

    private RacingCar(RacingCarName racingCarName) {
        this(racingCarName, 0);
    }

    private RacingCar(RacingCarName racingCarName, int distance) {
        this.racingCarName = racingCarName;
        this.distance = distance;
    }

    public static RacingCar create() {
        return new RacingCar();
    }

    public static RacingCar from(RacingCarName racingCarName) {
        return new RacingCar(racingCarName);
    }

    public static RacingCar of(RacingCarName racingCarName, int distance) {
        return new RacingCar(racingCarName, distance);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance++;
        }
    }

    public String distanceToString() {
        return DISTANCE_MARK.repeat(Math.max(0, distance));
    }

    public int distance() {
        return distance;
    }
}
