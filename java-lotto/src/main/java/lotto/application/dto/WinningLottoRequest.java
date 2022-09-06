package lotto.application.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class WinningLottoRequest {

    private final List<Integer> winningLotto = new ArrayList<>();
    private final List<Lotto> autoLotteries = new ArrayList<>();
    private final List<Lotto> manualLotteries = new ArrayList<>();

    private int purchasePrice;
    private int bonusNumber;

    private WinningLottoRequest() { }

    private WinningLottoRequest(List<Integer> winningLotto, List<Lotto> autoLotteries, List<Lotto> manualLotteries, int purchasePrice, int bonusNumber) {
        this.winningLotto.addAll(winningLotto);
        this.autoLotteries.addAll(autoLotteries);
        this.manualLotteries.addAll(manualLotteries);
        this.purchasePrice = purchasePrice;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoRequest of(List<Integer> winningLotteries, List<Lotto> autoLotteries, List<Lotto> manualLotteries, int purchasePrice, int bonusNumber) {
        return new WinningLottoRequest(winningLotteries, autoLotteries, manualLotteries, purchasePrice, bonusNumber);
    }

    public List<Integer> winningLotto() {
        return winningLotto;
    }

    public List<Lotto> getAutoLotteries() {
        return unmodifiableList(autoLotteries);
    }

    public List<Lotto> getManualLotteries() {
        return unmodifiableList(manualLotteries);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
