package nextstep.ladder.util;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineGeneratorTest {

    @Test
    @DisplayName("사람의 수 만큼 사다리의 Column 을 만듭니다.")
    void create() {
        List<Point> line = LineGenerator.createLine(4);

        assertThat(line).hasSize(4);
        assertThat(line.get(3).movable()).isFalse();
    }

}