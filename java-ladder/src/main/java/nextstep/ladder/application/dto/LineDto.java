package nextstep.ladder.application.dto;

import nextstep.ladder.domain.Line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineDto {

    private final List<PointDto> line;

    private LineDto(Line line) {
        this.line = toPointDto(line);
    }

    private List<PointDto> toPointDto(Line line) {
        return line.getPoints().stream()
                .map(PointDto::from)
                .collect(Collectors.toList());
    }

    public static LineDto from(Line line) {
        return new LineDto(line);
    }

    public List<PointDto> getLine() {
        return Collections.unmodifiableList(line);
    }
}
