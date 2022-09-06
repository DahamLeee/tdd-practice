package lotto.ui;

import lotto.application.dto.LottoIssueResponse;
import lotto.application.dto.WinningLottoResponse;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Collections;
import java.util.List;

public class ResultView {

    public void printLotteries(LottoIssueResponse lottoIssueResponse) {
        List<Lotto> autoLotteries = lottoIssueResponse.getAutoLotteries();
        List<Lotto> manualLotteries = lottoIssueResponse.getManualLotteries();

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLotteries.size(), autoLotteries.size());

        manualLotteries.forEach(lotto -> {
            lotto.getLotto().forEach(lottoNumber -> System.out.print(String.format("%d ", lottoNumber.lottoNumber())));
            System.out.println();
        });

        autoLotteries.forEach(lotto -> {
            lotto.getLotto().forEach(lottoNumber -> System.out.print(String.format("%d ", lottoNumber.lottoNumber())));
            System.out.println();
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
        if (rank.isBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getWinnings(), matchedCount);
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getWinnings(), matchedCount);
    }
}
