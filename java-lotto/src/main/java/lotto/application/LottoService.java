package lotto.application;

import lotto.application.dto.LottoIssueRequest;
import lotto.application.dto.LottoIssueResponse;
import lotto.application.dto.WinningLottoRequest;
import lotto.application.dto.WinningLottoResponse;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.AutoLottoGenerator;
import lotto.util.StatisticsCalculator;

import java.util.List;

public class LottoService {

    public LottoIssueResponse createLotto(LottoIssueRequest lottoIssueRequest) {
        AutoLottoGenerator lottoGenerator = new AutoLottoGenerator();
        List<Lotto> lotteries = lottoGenerator.issueLotto(lottoIssueRequest.getPurchasePrice());
        return LottoIssueResponse.createResponse(lotteries, lottoIssueRequest.getPurchasePrice());
    }

    public WinningLottoResponse calculateStatistics(WinningLottoRequest winningLottoRequest) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoRequest.getWinningLotteries());

        List<Rank> ranks = Rank.calculateRanks(winningLotto, winningLottoRequest.getMyLotteries());
        double earningRatio = StatisticsCalculator.calculateEarningRatio(winningLottoRequest.getPurchasePrice(), ranks);

        return WinningLottoResponse.of(ranks, earningRatio);
    }
}
