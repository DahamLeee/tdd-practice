package lotto.domain;

public class PurchasePrice {

    private static final int PRICE_PER_LOTTO = 1_000;

    private final int purchasePrice;

    private PurchasePrice(int purchasePrice) {
        validateMoney(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validateMoney(int purchasePrice) {
        if (purchasePrice < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(String.format("로또 한 장을 구매하기 위해선 1000원 이상의 금액이 필요합니다. *입력된 구입금액 %d", purchasePrice));
        }
    }

    public static PurchasePrice from(int money) {
        return new PurchasePrice(money);
    }

    public int purchasePrice() {
        return this.purchasePrice;
    }

    public int lottoCount() {
        return this.purchasePrice / PRICE_PER_LOTTO;
    }

}
