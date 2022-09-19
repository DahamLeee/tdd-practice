package nextstep.step4.domain;

import static nextstep.step4.util.LadderPointGenerator.generatePoint;
import static java.lang.Boolean.FALSE;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("한 지점에서 양방향 이동이 존재할 수는 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

}
