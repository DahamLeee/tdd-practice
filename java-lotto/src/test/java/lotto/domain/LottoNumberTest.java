package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("범위를 벗어나는 로또 번호 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalidLottoNumber(int lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.from(lottoNumber))
                .withMessage("로또 번호는 1 ~ 45 사이여야 합니다. *입력된 로또 번호 %d", lottoNumber);
    }

}