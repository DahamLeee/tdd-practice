package nextstep.ladder.domain;

import nextstep.ladder.util.LineGenerator;

import java.util.Collections;
import java.util.List;

public class Line {

    private static final int LEFTMOST = 0;
    private final List<Point> points;

    private Line(int countOfPerson) {
        this.points = LineGenerator.createLine(countOfPerson);
    }

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int goDown(int column) {
        if (column == LEFTMOST) {
            return leftmostMove(column);
        }

        return move(column);
    }

    private int leftmostMove(int column) {
        if (movableRight(column)) {
            return column + 1;
        }
        return column;
    }

    private int move(int column) {
        if (movableRight(column)) {
            return column + 1;
        }

        if (movableLeft(column)) {
            return column - 1;
        }

        return column;
    }

    private boolean movableLeft(int column) {
        return points.get(column - 1).movable();
    }

    private boolean movableRight(int column) {
        return points.get(column).movable();
    }
}
