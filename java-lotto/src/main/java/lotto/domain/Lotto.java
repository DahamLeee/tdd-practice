package lotto.domain;

import java.util.List;

import static java.util.Collections.*;

public class Lotto {

    private static final int COUNT_TO_COMPARE_BONUS = 5;

    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto from(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return unmodifiableList(lotto);
    }

    public boolean isMatchedBonusNumber(int matchCount, int bonusNumber) {
        if (matchCount != COUNT_TO_COMPARE_BONUS) {
            return false;
        }
        return lotto.contains(bonusNumber);
    }
}
