package nextstep.ladder.view;

import nextstep.ladder.application.dto.LadderCreateRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA_REGEX = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LadderCreateRequest requestLadder() {
        List<String> playerNames = inputPlayerNames();
        List<String> ladderResults = inputLadderResult();
        int ladderHeight = inputLadderHeight();

        return LadderCreateRequest.of(playerNames, ladderResults, ladderHeight);
    }

    private List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playersNameWithComma = inputString();

        return inputCommaToList(playersNameWithComma);
    }

    private List<String> inputLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String ladderResultsWithComma = inputString();

        return inputCommaToList(ladderResultsWithComma);
    }

    private List<String> inputCommaToList(String inputString) {
        return Arrays.stream(inputString.split(COMMA_REGEX))
                .collect(Collectors.toList());
    }

    private int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputInt();
    }

    public String requestLadderResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return inputString();
    }

    private String inputString() {
        return scanner.next();
    }

    private int inputInt() {
        return scanner.nextInt();
    }
}
