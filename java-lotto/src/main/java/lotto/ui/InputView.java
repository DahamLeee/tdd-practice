package lotto.ui;

import lotto.application.dto.LottoIssueRequest;
import lotto.application.dto.ManualLotteriesRequest;
import lotto.application.dto.ManualLottoRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class InputView {

    private static final String LOTTO_REGEX = ", ";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LottoIssueRequest issueLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        int purchasePrice = scannerInt();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scannerInt();
        scannerString();

        ManualLotteriesRequest manualLotteriesRequest = inputManualLotto(manualLottoCount);

        return LottoIssueRequest.of(purchasePrice, manualLotteriesRequest);
    }

    private ManualLotteriesRequest inputManualLotto(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        ManualLotteriesRequest manualLotteriesRequest = ManualLotteriesRequest.create();

        for (int i = 0; i < manualLottoCount; i++) {
            manualLotteriesRequest.addManualLotto(inputOneLotto());
        }

        return manualLotteriesRequest;
    }

    private ManualLottoRequest inputOneLotto() {
        return Arrays.stream(scanner.nextLine().split(LOTTO_REGEX))
                .map(Integer::parseInt)
                .collect(collectingAndThen(toList(), ManualLottoRequest::of));
    }

    public List<Integer> winningLottoRequest() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputWinningLotto();
    }

    private List<Integer> inputWinningLotto() {
        String winningLotto = scannerString();
        return Arrays.stream(winningLotto.split(LOTTO_REGEX))
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
