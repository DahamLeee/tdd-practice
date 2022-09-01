package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("일치하는 로또 번호 개수 구하기")
    void findMatchedCount() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.from(List.of(2, 3, 4, 5, 6, 7));

        int matchedCount = winningLotto.findMatchedCount(lotto);

        assertThat(matchedCount).isEqualTo(5);
    }

}