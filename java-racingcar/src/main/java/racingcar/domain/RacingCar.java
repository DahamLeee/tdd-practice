package racingcar.domain;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    private final RacingCarName racingCarName;

    private final Distance distance;

    protected RacingCar() {
        this(RacingCarName.from("base"));
    }

    private RacingCar(RacingCarName racingCarName) {
        this(racingCarName, Distance.from(0));
    }

    private RacingCar(RacingCarName racingCarName, Distance distance) {
        this.racingCarName = racingCarName;
        this.distance = distance;
    }

    public static RacingCar from(RacingCarName racingCarName) {
        return new RacingCar(racingCarName);
    }

    public static RacingCar of(RacingCarName racingCarName, Distance distance) {
        return new RacingCar(racingCarName, distance);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance.goStraight();
        }
    }

    public String carName() {
        return racingCarName.racingCarName();
    }

    public int distance() {
        return distance.distance();
    }
}
