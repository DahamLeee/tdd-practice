package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class LottoIssueResponse {

    private final List<Lotto> lotteries = new ArrayList<>();
    private int purchasePrice;

    private LottoIssueResponse() { }

    private LottoIssueResponse(List<Lotto> lotteries, int purchasePrice) {
        this.lotteries.addAll(lotteries);
        this.purchasePrice = purchasePrice;
    }

    public static LottoIssueResponse createResponse(List<Lotto> lotteries, int purchasePrice) {
        return new LottoIssueResponse(lotteries, purchasePrice);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLotteries() {
        return unmodifiableList(lotteries);
    }
}
