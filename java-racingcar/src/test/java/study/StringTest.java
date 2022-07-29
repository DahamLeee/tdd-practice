package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {

    @Test
    @DisplayName("split 메서드 테스트하기")
    void splitOneAndTwo() {
        String[] result = "1,2".split(",");
        assertAll(
                () -> assertThat(result).hasSize(2),
                () -> assertThat(result).containsExactly("1", "2")
        );
    }

    @Test
    @DisplayName("스플릿 표현식이 없을 때에 대한 테스트")
    void splitOneContainsExactlyTest() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("subString 메서드 테스트")
    void substringRoundBracketsTest() {
        String givenString = "(1,2)";

        String result = givenString.substring(1, givenString.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 charAt 메서드 테스트")
    void charAtSuccessTest() {
        String givenString = "abc";

        char firstCharacter = givenString.charAt(0);
        char secondCharacter = givenString.charAt(1);
        char thirdCharacter = givenString.charAt(2);

        assertAll(
                () -> assertThat(firstCharacter).isEqualTo('a'),
                () -> assertThat(secondCharacter).isEqualTo('b'),
                () -> assertThat(thirdCharacter).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("인덱스의 범위를 초과하는 charAt 을 사용했을 때 예외")
    void charAtFailureTest() {
        String givenString = "abc";

        assertThatThrownBy(() -> {
            char indexOutOfBoundCharacter = givenString.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
