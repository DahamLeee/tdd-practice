package nextstep.step4.domain;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void first() {
        assertThat(Point.first(TRUE).move()).isOne();
        assertThat(Point.first(FALSE).move()).isZero();
    }

    @Test
    void nextStay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isOne();
    }

    @Test
    void nextLeft() {
        Point second = Point.first(true).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @Test
    void nextRight() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isZero();
    }

}