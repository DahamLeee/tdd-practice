package lotto.application;

import lotto.application.dto.LottoIssueRequest;
import lotto.application.dto.LottoIssueResponse;
import lotto.application.dto.WinningLottoRequest;
import lotto.application.dto.WinningLottoResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.AutoLottoGenerator;
import lotto.util.StatisticsCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    public LottoIssueResponse createLotto(LottoIssueRequest lottoIssueRequest) {
        PurchasePrice purchasePrice = PurchasePrice.from(lottoIssueRequest.getPurchasePrice());
        List<Lotto> manualLotteries = lottoIssueRequest.toLotto();
        List<Lotto> lotteries = AutoLottoGenerator.issueLotto(purchasePrice, manualLotteries.size());
        return LottoIssueResponse.createResponse(lotteries, manualLotteries, lottoIssueRequest.getPurchasePrice());
    }

    public WinningLottoResponse calculateStatistics(WinningLottoRequest winningLottoRequest) {
        LottoNumber bonusNumber = LottoNumber.from(winningLottoRequest.getBonusNumber());
        WinningLotto winningLotto = WinningLotto.from(createLottoNumbers(winningLottoRequest.winningLotto()));
        PurchasePrice purchasePrice = PurchasePrice.from(winningLottoRequest.getPurchasePrice());

        List<Rank> ranks = Rank.calculateRanks(winningLotto, winningLottoRequest.getAutoLotteries(), winningLottoRequest.getManualLotteries(), bonusNumber);
        double earningRatio = StatisticsCalculator.calculateEarningRatio(purchasePrice, ranks);

        return WinningLottoResponse.of(ranks, earningRatio);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> winningLotteries) {
        return winningLotteries.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
