package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningLotteries = new ArrayList<>();

    private WinningLotto(List<Integer> winningLotteries) {
        this.winningLotteries.addAll(winningLotteries);
    }

    public static WinningLotto from(List<Integer> winningLotto) {
        return new WinningLotto(winningLotto);
    }

    public int findMatchedCount(Lotto lotto) {
        return (int) this.winningLotteries.stream()
                .filter(winningLotto -> lotto.getLotto().contains(winningLotto)).count();
    }
}
