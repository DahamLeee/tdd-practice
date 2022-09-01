package lotto.util;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int PRICE_PER_LOTTO = 1_000;
    private static final List<Integer> LOTTO_NUMBER_SET = new ArrayList<>();

    public AutoLottoGenerator() {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            LOTTO_NUMBER_SET.add(number);
        }
    }

    public List<Lotto> issueLotto(int purchasePrice) {
        int lottoCount = calculateLottoCount(purchasePrice);

        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(LOTTO_NUMBER_SET);

            lotteries.add(generateLotto());
        }

        return lotteries;
    }

    private int calculateLottoCount(int purchasePrice) {
        if (purchasePrice < 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 작을 수 없습니다.");
        }

        return purchasePrice / PRICE_PER_LOTTO;
    }

    private Lotto generateLotto() {
        return LOTTO_NUMBER_SET
                .subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::from));
    }

}
