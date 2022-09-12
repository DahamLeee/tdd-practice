package nextstep.ladder.domain;

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

}
