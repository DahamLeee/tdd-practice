package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            throw new IllegalArgumentException(String.format("로또 번호는 1 ~ 45 사이여야 합니다. *입력된 로또 번호 %d", lottoNumber));
        }
    }

    public static LottoNumber from(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public int lottoNumber() {
        return lottoNumber;
    }
}
