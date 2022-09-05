package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    LOSER(0, 0, false)
    ;

    private final int matchCount;
    private final int winnings;
    private final boolean isBonus;

    Rank(int matchCount, int winnings, boolean isBonus) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.isBonus = isBonus;
    }

    public static List<Rank> calculateRanks(WinningLotto winningLotto, List<Lotto> targetLotteries, LottoNumber bonusNumber) {
        return targetLotteries.stream()
                .map(lotto -> findRank(winningLotto, lotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private static Rank findRank(WinningLotto winningLotto, Lotto targetLotto, LottoNumber bonusNumber) {
        int matchedCount = winningLotto.findMatchedCount(targetLotto);

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchedCount)
                .filter(matchBonusNumber(targetLotto, bonusNumber))
                .findFirst()
                .orElse(LOSER);
    }

    private static Predicate<Rank> matchBonusNumber(Lotto targetLotto, LottoNumber bonusNumber) {
        return rank -> rank.isBonus == targetLotto.isMatchedBonusNumber(rank.matchCount, bonusNumber);
    }

    public static int totalWinnings(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(rank -> rank.winnings)
                .sum();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
