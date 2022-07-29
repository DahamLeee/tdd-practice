package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.addAll(List.of(1, 1, 2, 3));
    }

    @Test
    @DisplayName("Set 크기 확인 테스트")
    void setSizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("Set contains 메서드 테스트")
    void setContainsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContainsWithParameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsSuccessAndFailureTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("setNumbers")
    void setContainsMethodSourceTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> setNumbers() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false)
        );
    }
}
