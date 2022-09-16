package nextstep.ladder.view;

import nextstep.ladder.application.dto.LadderCreateResponse;
import nextstep.ladder.application.dto.LadderDto;
import nextstep.ladder.application.dto.LadderResultDto;

import java.util.List;

public class ResultView {

    private static final String UNMOVABLE_LADDER = "|";
    private static final String BLANK = "     ";
    private static final String MOVABLE_LADDER = "|-----";

    public void printLadderResponseView(LadderCreateResponse createResponse) {
        System.out.println("실행 결과");
        printPlayerName(createResponse.getPlayerNames());
        printLadders(createResponse.getLadderDto());
        printLadderResult(createResponse.getLadderResultDto());
    }

    private void printPlayerName(List<String> playerNames) {
        playerNames.forEach(playerName -> System.out.printf("%-6s", playerName));
        System.out.println();
    }

    private void printLadders(LadderDto ladderDto) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderDto.getLadders()
                .forEach(lineDto -> {
                    lineDto.getLine().forEach(pointDto -> {
                        ladderBuilder.append(ladderToView(pointDto.movable()));
                    });
                    ladderBuilder.append("\n");
                });
        System.out.print(ladderBuilder);
    }

    private void printLadderResult(LadderResultDto ladderResultDto) {
        ladderResultDto.getLadderResults().forEach(ladderResult -> System.out.printf("%-6s", ladderResult));
    }

    private String ladderToView(boolean movable) {
        if (movable) {
            return String.format("%s", MOVABLE_LADDER);
        }
        return String.format("%s%s", UNMOVABLE_LADDER, BLANK);
    }
}
