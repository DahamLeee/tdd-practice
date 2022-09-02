package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class WinningLottoRequest {

    private final List<Integer> winningLotteries = new ArrayList<>();
    private final List<Lotto> myLotteries = new ArrayList<>();

    private int purchasePrice;

    private WinningLottoRequest() { }

    private WinningLottoRequest(List<Integer> winningLotteries, List<Lotto> myLotteries, int purchasePrice) {
        this.winningLotteries.addAll(winningLotteries);
        this.myLotteries.addAll(myLotteries);
        this.purchasePrice = purchasePrice;
    }

    public static WinningLottoRequest of(List<Integer> winningLotteries, List<Lotto> myLotteries, int purchasePrice) {
        return new WinningLottoRequest(winningLotteries, myLotteries, purchasePrice);
    }

    public List<Integer> getWinningLotteries() {
        return unmodifiableList(winningLotteries);
    }

    public List<Lotto> getMyLotteries() {
        return unmodifiableList(myLotteries);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
