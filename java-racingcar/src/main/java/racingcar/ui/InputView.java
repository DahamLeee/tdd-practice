package racingcar.ui;

import racingcar.application.dto.RacingRequest;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public RacingRequest createRacingRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String racingCarNameWithComma = inputScannerString();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = inputScannerInt();

        List<String> racingCarNames = splitCarNames(racingCarNameWithComma);

        return new RacingRequest(racingCarNames, moveCount);
    }

    private List<String> splitCarNames(String racingCarNameWithComma) {
        return stream(racingCarNameWithComma.split(","))
                .collect(Collectors.toList());
    }

    private String inputScannerString() {
        return scanner.next();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }
}
