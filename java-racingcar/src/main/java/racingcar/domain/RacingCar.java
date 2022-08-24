package racingcar.domain;

public class RacingCar {

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;
    private int distance;

    private RacingCar() { }

    private RacingCar(int distance) {
        this.distance = distance;
    }

    public static RacingCar create() {
        return new RacingCar();
    }

    public static RacingCar from(int distance) {
        return new RacingCar(distance);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
