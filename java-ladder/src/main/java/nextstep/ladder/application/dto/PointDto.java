package nextstep.ladder.application.dto;

import nextstep.ladder.domain.Point;

public class PointDto {

    private final boolean point;

    private PointDto(boolean point) {
        this.point = point;
    }

    public static PointDto from(Point point) {
        return new PointDto(point.movable());
    }

    public boolean movable() {
        return this.point;
    }

}
