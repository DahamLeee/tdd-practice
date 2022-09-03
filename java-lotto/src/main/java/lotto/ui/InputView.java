package lotto.ui;

import lotto.application.dto.LottoIssueRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class InputView {

    private static final String WINNING_LOTTO_REGEX = ", ";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LottoIssueRequest issueLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        int purchasePrice = scannerInt();
        scannerString();
        return LottoIssueRequest.from(purchasePrice);
    }

    public List<Integer> winningLottoRequest() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputWinningLotto();
    }

    private List<Integer> inputWinningLotto() {
        String winningLotto = scannerString();
        return Arrays.stream(winningLotto.split(WINNING_LOTTO_REGEX))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scannerInt();
    }

    private String scannerString() {
        return scanner.nextLine();
    }

    private int scannerInt() {
        return scanner.nextInt();
    }
}
