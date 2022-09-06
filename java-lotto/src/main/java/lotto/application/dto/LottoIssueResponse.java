package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class LottoIssueResponse {

    private final List<Lotto> autoLotteries = new ArrayList<>();
    private final List<Lotto> manualLotteries = new ArrayList<>();
    private int purchasePrice;

    private LottoIssueResponse() { }

    private LottoIssueResponse(List<Lotto> autoLotteries, List<Lotto> manualLotteries, int purchasePrice) {
        this.autoLotteries.addAll(autoLotteries);
        this.manualLotteries.addAll(manualLotteries);
        this.purchasePrice = purchasePrice;
    }

    public static LottoIssueResponse createResponse(List<Lotto> lotteries, List<Lotto> manualLotteries, int purchasePrice) {
        return new LottoIssueResponse(lotteries, manualLotteries, purchasePrice);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getAutoLotteries() {
        return unmodifiableList(autoLotteries);
    }

    public List<Lotto> getManualLotteries() {
        return unmodifiableList(manualLotteries);
    }
}
