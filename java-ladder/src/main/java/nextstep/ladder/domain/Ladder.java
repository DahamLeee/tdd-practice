package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INCLUSIVE = 1;

    private final List<Line> ladder;

    private Ladder(int height, int countOfPerson) {
        this.ladder = IntStream.rangeClosed(START_INCLUSIVE, height)
                .mapToObj(row -> Line.from(countOfPerson))
                .collect(Collectors.toList());
    }

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int height, int countOfPerson) {
        return new Ladder(height, countOfPerson);
    }

    public static Ladder of(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int climb(int column) {
        for (Line line : ladder) {
            column = line.goDown(column);
        }

        return column;
    }
}
