package qna.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qna.CannotDeleteException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class QuestionTest {
    public static final Question Q1 = new Question("title1", "contents1").writeBy(UserTest.JAVAJIGI);
    public static final Question Q2 = new Question("title2", "contents2").writeBy(UserTest.SANJIGI);

    @Test
    @DisplayName("질문의 작성자와 답변자 모두 일치할 경우 질문 삭제 가능")
    void deleteQuestion() throws Exception {
        Question question = new Question("wangtak", "backend developer").writeBy(UserTest.JAVAJIGI);

        question.addAnswer(new Answer(UserTest.JAVAJIGI, question, "답변1"));
        question.addAnswer(new Answer(UserTest.JAVAJIGI, question, "답변2"));

        List<DeleteHistory> deleteHistories = question.deleteQuestionAndAnswer(UserTest.JAVAJIGI);

        assertAll(
                () -> assertThat(question.isDeleted()).isTrue(),
                () -> assertThat(deleteHistories).hasSize(3)
        );
    }

    @Test
    @DisplayName("질문의 작성자와 삭제하려는 사용자가 다를 경우 질문 삭제 불가능")
    void invalidDeleteQuestionDifferentWriter() throws Exception {
        Question question = new Question("wangtak", "backend developer").writeBy(UserTest.JAVAJIGI);

        assertThatThrownBy(() -> question.deleteQuestionAndAnswer(UserTest.SANJIGI))
                .isInstanceOf(CannotDeleteException.class)
                .hasMessage("질문을 삭제할 권한이 없습니다.");
    }

    @Test
    @DisplayName("질문의 작성자는 일치하지만 답변자가 다른 경우 삭제 불가능")
    void invalidDeleteQuestionDifferentAnswerWriter() {
        Question question = new Question("wangtak", "backend developer").writeBy(UserTest.JAVAJIGI);

        question.addAnswer(new Answer(UserTest.JAVAJIGI, question, "답변1"));
        question.addAnswer(new Answer(UserTest.SANJIGI, question, "답변2"));

        assertThatThrownBy(() -> question.deleteQuestionAndAnswer(UserTest.JAVAJIGI))
                .isInstanceOf(CannotDeleteException.class)
                .hasMessage("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
    }
}
