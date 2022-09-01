package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSER(0, 0)
    ;

    private final int matchCount;
    private final int winnings;

    Rank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank findRank(WinningLotto winningLotto, Lotto targetLotto) {
        int matchedCount = winningLotto.findMatchedCount(targetLotto);

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchedCount)
                .findFirst()
                .orElse(LOSER);
    }
}
