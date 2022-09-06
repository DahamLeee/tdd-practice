package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoIssueRequest {

    private int purchasePrice;
    private ManualLotteriesRequest manualLotteriesRequest;

    private LottoIssueRequest() { }

    private LottoIssueRequest(int purchasePrice, ManualLotteriesRequest manualLotteriesRequest) {
        this.purchasePrice = purchasePrice;
        this.manualLotteriesRequest = manualLotteriesRequest;
    }

    public static LottoIssueRequest of(int purchasePrice, ManualLotteriesRequest manualLotteriesRequest) {
        return new LottoIssueRequest(purchasePrice, manualLotteriesRequest);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> toLotto() {
        return manualLotteriesRequest.getManualLotteries().stream()
                .map(ManualLottoRequest::toLotto)
                .collect(Collectors.toList());
    }

}
