package racingcar.ui;

import racingcar.application.dto.RacingRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public RacingRequest createRacingRequest() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int racingCarCount = inputScannerInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = inputScannerInt();

        return new RacingRequest(racingCarCount, moveCount);
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }
}
