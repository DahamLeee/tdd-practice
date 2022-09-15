package nextstep.ladder.view;

import nextstep.ladder.application.dto.LadderCreateRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PLAYER_NAME_DIVIDER = ",";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LadderCreateRequest requestLadder() {
        List<String> playerNames = inputPlayerNames();
        int ladderHeight = inputLadderHeight();

        return LadderCreateRequest.of(playerNames, ladderHeight);
    }

    private List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playersNameWithComma = inputString();

        return playersNameToList(playersNameWithComma);
    }

    private List<String> playersNameToList(String playersNameWithComma) {
        return Arrays.stream(playersNameWithComma.split(PLAYER_NAME_DIVIDER))
                .collect(Collectors.toList());
    }

    private int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputInt();
    }

    private String inputString() {
        return scanner.next();
    }

    private int inputInt() {
        return scanner.nextInt();
    }

}
