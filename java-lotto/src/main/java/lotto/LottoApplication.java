package lotto;

import lotto.application.LottoService;
import lotto.application.dto.LottoIssueRequest;
import lotto.application.dto.LottoIssueResponse;
import lotto.application.dto.WinningLottoRequest;
import lotto.application.dto.WinningLottoResponse;
import lotto.domain.Lotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        LottoIssueResponse lottoIssueResponse = requestCreateLottoAPI();
        resultView.printLotteries(lottoIssueResponse);

        WinningLottoResponse winningLottoResponse = requestWinningLottoAPI(lottoIssueResponse.getLotteries(), lottoIssueResponse.getPurchasePrice());
        resultView.printStatistics(winningLottoResponse);
    }

    private static LottoIssueResponse requestCreateLottoAPI() {
        LottoIssueRequest lottoIssueRequest = inputView.issueLotto();

        return lottoService.createLotto(lottoIssueRequest);
    }

    private static WinningLottoResponse requestWinningLottoAPI(List<Lotto> myLotteries, int purchasePrice) {
        List<Integer> winningLotto = inputView.winningLottoRequest();
        int bonusNumber = inputView.bonusNumber();

        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of(winningLotto, myLotteries, purchasePrice, bonusNumber);

        return lottoService.calculateStatistics(winningLottoRequest);
    }
}
