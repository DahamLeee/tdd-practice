package nextstep.step4.domain;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    private static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return this.index;
    }

    public static Point first(boolean right) {
        return Point.of(0, Direction.first(right));
    }

    public Point next() {
        return Point.of(index + 1, direction.next());
    }

    public Point next(boolean right) {
        return Point.of(index + 1, direction.next(right));
    }

    public Point last() {
        return Point.of(index + 1, direction.last());
    }
}
