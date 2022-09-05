package lotto.util;

import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StatisticsCalculatorTest {

    @Test
    @DisplayName("로또 구매에 대한 수익률 구하기")
    void calculateEarningRatioTest() {
        double earningRatio = StatisticsCalculator.calculateEarningRatio(PurchasePrice.from(14_000), List.of(Rank.FIFTH));
        assertThat(earningRatio).isEqualTo(0.35);
    }

    @Test
    @DisplayName("수익률을 구할 때 0원 이하의 금액이 올 경우 예외 처리")
    void invalidCalculateEarningRatio() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                StatisticsCalculator.calculateEarningRatio(PurchasePrice.from(0), List.of(Rank.FIRST))
        ).withMessage("로또 한 장을 구매하기 위해선 1000원 이상의 금액이 필요합니다. *입력된 구입금액 %d", 0);
    }

}