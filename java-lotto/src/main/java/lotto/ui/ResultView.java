package lotto.ui;

import lotto.application.dto.LottoIssueResponse;
import lotto.application.dto.WinningLottoResponse;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Collections;
import java.util.List;

public class ResultView {

    public void printLotteries(LottoIssueResponse lottoIssueResponse) {
        List<Lotto> lotteries = lottoIssueResponse.getLotteries();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        lotteries.forEach(lotto -> {
            System.out.println(lotto.getLotto());
        });
    }

    public void printStatistics(WinningLottoResponse winningLottoResponse) {
        System.out.println("당첨 통계");
        System.out.println("-------------");

        for (Rank rank : Rank.values()) {
            int matchedCount = Collections.frequency(winningLottoResponse.getRanks(), rank);
            printMatchedRankCount(rank, matchedCount);
        }
        System.out.printf("총 수익률은 %.2f 입니다.", winningLottoResponse.getEarningRatio());
    }

    private void printMatchedRankCount(Rank rank, int matchedCount) {
        System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getWinnings(), matchedCount);
    }
}
