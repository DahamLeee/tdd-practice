package lotto.domain;

import java.util.List;

import static java.util.Collections.*;

public class Lotto {

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
}
