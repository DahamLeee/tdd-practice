package lotto.application.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoRequest {

    private final List<Integer> manualLotto = new ArrayList<>();

    private ManualLottoRequest() { }

    private ManualLottoRequest(List<Integer> manualLotto) {
        if (manualLotto.size() != 6) {
            throw new IllegalArgumentException(String.format("로또 한 장은 6개의 숫자를 가지고 있어야 합니다. *입력된 번호의 개수: %d", manualLotto.size()));
        }
        this.manualLotto.addAll(manualLotto);
    }

    public static ManualLottoRequest of(List<Integer> manualLotto) {
        return new ManualLottoRequest(manualLotto);
    }

    public List<Integer> manualLotto() {
        return Collections.unmodifiableList(manualLotto);
    }

    public Lotto toLotto() {
        return manualLotto.stream()
                .map(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::from));
    }

}
