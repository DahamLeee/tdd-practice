package nextstep.ladder.util;

import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {

    private static final int PREVIOUS_COLUMN = -1;
    private static final boolean EMPTY_LINE = false;
    private static final Random random = new Random();

    private LineGenerator() { }

    public static List<Point> createLine(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        drawFirstLine(points);
        drawMiddleLine(points, countOfPerson);
        drawLastLine(points);

        return points;
    }

    private static void drawFirstLine(List<Point> points) {
        points.add(drawPoint());
    }

    private static void drawMiddleLine(List<Point> points, int countOfPerson) {
        for (int column = 1; column < countOfPerson - 1; column++) {
            if (!previousPointMovable(points, column)) {
                points.add(drawPoint());
                continue;
            }
            points.add(emptyPoint());
        }
    }

    private static boolean previousPointMovable(List<Point> points, int currentColumn) {
        return points.get(currentColumn + PREVIOUS_COLUMN).movable();
    }

    private static void drawLastLine(List<Point> points) {
        points.add(emptyPoint());
    }

    private static Point emptyPoint() {
        return Point.from(EMPTY_LINE);
    }

    private static Point drawPoint() {
        return Point.from(random.nextBoolean());
    }
}
