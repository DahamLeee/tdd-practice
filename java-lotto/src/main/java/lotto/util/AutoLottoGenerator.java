package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchasePrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBER_SET = new ArrayList<>();

    public AutoLottoGenerator() {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            LOTTO_NUMBER_SET.add(number);
        }
    }

    public List<Lotto> issueLotto(PurchasePrice purchasePrice) {
        int lottoCount = purchasePrice.lottoCount();

        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(LOTTO_NUMBER_SET);

            lotteries.add(generateLotto());
        }

        return lotteries;
    }

    private Lotto generateLotto() {
        return LOTTO_NUMBER_SET
                .subList(0, 6)
                .stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::from));
    }

}
