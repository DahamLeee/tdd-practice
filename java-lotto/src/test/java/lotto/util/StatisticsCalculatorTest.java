package lotto.util;

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
        double earningRatio = StatisticsCalculator.calculateEarningRatio(14_000, List.of(Rank.FIFTH));
        assertThat(earningRatio).isEqualTo(0.35);
    }

    @Test
    @DisplayName("수익률을 구할 때 0원 이하의 금액이 올 경우 예외 처리")
    void invalidCalculateEarningRatio() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                StatisticsCalculator.calculateEarningRatio(0, List.of(Rank.FIRST))
        ).withMessage("구매 금액이 0원 이하일 수 없습니다. * 구매 금액 : %d", 0);
    }

}