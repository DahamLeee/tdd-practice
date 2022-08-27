package racingcar.domain;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    private RacingCarName racingCarName;
    private int distance;

    protected RacingCar() {
        this(RacingCarName.from("base"), 0);
    }

    private RacingCar(RacingCarName racingCarName) {
        this(racingCarName, 0);
    }

    private RacingCar(RacingCarName racingCarName, int distance) {
        this.racingCarName = racingCarName;
        this.distance = distance;
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

    public String carName() {
        return racingCarName.racingCarName();
    }

    public int distance() {
        return distance;
    }
}
