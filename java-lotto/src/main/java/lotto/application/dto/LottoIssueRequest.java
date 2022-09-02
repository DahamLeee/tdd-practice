package lotto.application.dto;

public class LottoIssueRequest {

    private int purchasePrice;

    private LottoIssueRequest() { }

    private LottoIssueRequest(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public static LottoIssueRequest from(int purchasePrice) {
        return new LottoIssueRequest(purchasePrice);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
