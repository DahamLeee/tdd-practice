package lotto.application.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManualLotteriesRequest {

    private final List<ManualLottoRequest> manualLotteries = new ArrayList<>();

    private ManualLotteriesRequest() { }

    public static ManualLotteriesRequest create() {
        return new ManualLotteriesRequest();
    }

    public void addManualLotto(ManualLottoRequest manualLottoRequest) {
        this.manualLotteries.add(manualLottoRequest);
    }

    public int manualLottoCount() {
        return this.manualLotteries.size();
    }

    public List<ManualLottoRequest> getManualLotteries() {
        return Collections.unmodifiableList(manualLotteries);
    }
}
