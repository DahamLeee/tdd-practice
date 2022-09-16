package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    /**
     *  0    1    2    3
     *  |----|    |    |
     *  |    |----|    |
     *  |----|    |----|
     *  |    |----|    |
     *  |----|    |----|
     *  0    1    2    3
     *
     *  0:2
     *  1:3
     *  2:1
     *  3:0
     */

    @BeforeEach
    void setUp() {
        Line firstRow = Line.of(List.of(Point.from(true), Point.from(false), Point.from(false), Point.from(false)));
        Line secondRow = Line.of(List.of(Point.from(false), Point.from(true), Point.from(false), Point.from(false)));
        Line thirdRow = Line.of(List.of(Point.from(true), Point.from(false), Point.from(true), Point.from(false)));
        Line fourthRow = Line.of(List.of(Point.from(false), Point.from(true), Point.from(false), Point.from(false)));
        Line fifthRow = Line.of(List.of(Point.from(true), Point.from(false), Point.from(true), Point.from(false)));

        ladder = Ladder.of(List.of(firstRow, secondRow, thirdRow, fourthRow, fifthRow));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:3", "2:1", "3:0"}, delimiter = ':')
    void climb(int startColumn, int expectedColumn) {
        int column = ladder.climb(startColumn);
        assertThat(column).isEqualTo(expectedColumn);
    }

}