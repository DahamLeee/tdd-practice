package lotto.application.dto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class WinningLottoRequest {

    private final List<Integer> winningLotto = new ArrayList<>();
    private final List<Lotto> myLotteries = new ArrayList<>();

    private int purchasePrice;
    private int bonusNumber;

    private WinningLottoRequest() { }

    private WinningLottoRequest(List<Integer> winningLotto, List<Lotto> myLotteries, int purchasePrice, int bonusNumber) {
        this.winningLotto.addAll(winningLotto);
        this.myLotteries.addAll(myLotteries);
        this.purchasePrice = purchasePrice;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoRequest of(List<Integer> winningLotteries, List<Lotto> myLotteries, int purchasePrice, int bonusNumber) {
        return new WinningLottoRequest(winningLotteries, myLotteries, purchasePrice, bonusNumber);
    }

    public List<Integer> winningLotto() {
        return winningLotto;
    }

    public List<Lotto> getMyLotteries() {
        return unmodifiableList(myLotteries);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
