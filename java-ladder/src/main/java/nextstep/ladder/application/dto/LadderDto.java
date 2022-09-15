package nextstep.ladder.application.dto;

import nextstep.ladder.domain.Ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {

    private final List<LineDto> ladders;

    private LadderDto(Ladder ladder) {
        this.ladders = toLineDto(ladder);
    }

    private List<LineDto> toLineDto(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LineDto::from)
                .collect(Collectors.toList());
    }

    public static LadderDto from(Ladder ladder) {
        return new LadderDto(ladder);
    }

    public List<LineDto> getLadders() {
        return Collections.unmodifiableList(ladders);
    }
}
