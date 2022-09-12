package nextstep.ladder.domain;

import nextstep.ladder.util.LineGenerator;

import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(int countOfPerson) {
        this.points = LineGenerator.createLine(countOfPerson);
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

}
