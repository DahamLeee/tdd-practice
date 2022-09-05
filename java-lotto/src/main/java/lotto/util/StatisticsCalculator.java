package lotto.util;

import lotto.domain.PurchasePrice;
import lotto.domain.Rank;

import java.util.List;

public class StatisticsCalculator {

    private StatisticsCalculator() { }

    public static double calculateEarningRatio(PurchasePrice purchasePrice, List<Rank> ranks) {
        int totalWinnings = Rank.totalWinnings(ranks);

        double rate = (double) totalWinnings / purchasePrice.purchasePrice();
        return Math.floor(rate * 100) / 100;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException(String.format("구매 금액이 0원 이하일 수 없습니다. * 구매 금액 : %d", purchasePrice));
        }
    }
}
