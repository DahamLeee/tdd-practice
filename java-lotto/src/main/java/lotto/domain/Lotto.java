package lotto.domain;

import java.util.List;

import static java.util.Collections.*;

public class Lotto {

    private static final int COUNT_TO_COMPARE_BONUS = 5;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        // TODO: lotto 의 크기가 6이 아닐경우 exception throw
        this.lotto = lotto;
    }

    public static Lotto from(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    public List<LottoNumber> getLotto() {
        return unmodifiableList(lotto);
    }

    public boolean isMatchedBonusNumber(int matchCount, LottoNumber bonusNumber) {
        if (matchCount != COUNT_TO_COMPARE_BONUS) {
            return false;
        }
        return lotto.contains(bonusNumber);
    }
}
