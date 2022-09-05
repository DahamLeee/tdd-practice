package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AutoLottoGeneratorTest {

    @Test
    void autoLottoGeneratorTest() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        List<Lotto> lotteries = autoLottoGenerator.issueLotto(PurchasePrice.from(3_000));

        assertAll(
                () -> assertThat(lotteries).hasSize(3),
                () -> lotteries.forEach(lotto ->
                        assertThat(lotto.getLotto()).hasSize(6))
        );
    }
}