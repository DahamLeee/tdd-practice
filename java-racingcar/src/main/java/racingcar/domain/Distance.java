package racingcar.domain;

public class Distance {

    private int distance;

    protected Distance() { }

    private Distance(int distance) {
        validateNegativeDistance(distance);
        this.distance = distance;
    }

    private void validateNegativeDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(String.format("거리는 음수일 수 없습니다. *(입력한 거리 %s)", distance));
        }
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public void goStraight() {
        this.distance++;
    }

    public int distance() {
        return distance;
    }
}
