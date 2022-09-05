package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningLotteries = new ArrayList<>();

    private WinningLotto(List<LottoNumber> winningLotteries) {
        this.winningLotteries.addAll(winningLotteries);
    }

    public static WinningLotto from(List<LottoNumber> winningLotto) {
        return new WinningLotto(winningLotto);
    }

    public int findMatchedCount(Lotto lotto) {
        return (int) this.winningLotteries.stream()
                .filter(winningLotto -> lotto.getLotto().contains(winningLotto)).count();
    }
}
