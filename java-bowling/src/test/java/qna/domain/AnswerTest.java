package qna.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qna.CannotDeleteException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswerTest {
    public static final Answer A1 = new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(UserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

    @Test
    @DisplayName("답변을 작성한 사용자와 삭제하려는 사용자가 일치할 경우 삭제 가능")
    void deleteAnswer() throws Exception {
        Answer answer = new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "It'll be deleted");
        answer.deleteAnswer(UserTest.JAVAJIGI);
        assertThat(answer.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("답변을 작성한 사용자와 삭제하려는 사용자가 일치하지 않을 경우 삭제 불가능")
    void invalidDeleteAnswer() {
        Answer answer = new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "It can't delete");
        assertThatThrownBy(() -> answer.deleteAnswer(UserTest.SANJIGI))
                .isInstanceOf(CannotDeleteException.class)
                .hasMessage("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
    }
}
