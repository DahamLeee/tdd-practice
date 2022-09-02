package lotto.application.dto;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class WinningLottoResponse {

    private final List<Rank> ranks = new ArrayList<>();
    private double earningRatio;

    private WinningLottoResponse() { }

    private WinningLottoResponse(List<Rank> ranks, double earningRatio) {
        this.ranks.addAll(ranks);
        this.earningRatio = earningRatio;
    }

    public static WinningLottoResponse of(List<Rank> ranks, double earningRatio) {
        return new WinningLottoResponse(ranks, earningRatio);
    }

    public List<Rank> getRanks() {
        return unmodifiableList(ranks);
    }

    public double getEarningRatio() {
        return earningRatio;
    }
}
