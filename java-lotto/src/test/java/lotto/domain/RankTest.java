package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "{index} -> findRank - {1}")
    @MethodSource("lottoSet")
    void findRank(Lotto lotto, Rank expectedRank) {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Rank> rank = Rank.calculateRanks(winningLotto, List.of(lotto), bonusNumber);
        assertThat(rank.get(0)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> lottoSet() {
        return Stream.of(
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), Rank.SECOND),
                Arguments.of(Lotto.from(List.of(2, 3, 4, 5, 6, 8)), Rank.THIRD),
                Arguments.of(Lotto.from(List.of(3, 4, 5, 6, 7, 8)), Rank.FOURTH),
                Arguments.of(Lotto.from(List.of(4, 5, 6, 7, 8, 8)), Rank.FIFTH),
                Arguments.of(Lotto.from(List.of(5, 6, 7, 8, 9, 10)), Rank.LOSER)
        );
    }

}