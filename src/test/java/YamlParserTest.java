import exception.*;
import model.QuestionsSet;
import org.junit.Test;

import static org.junit.Assert.*;

public class YamlParserTest {
    @Test(expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundException() throws ParseException {
        //given
        String path = "src\\test\\files\\file_not_found.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = EmptyFileException.class)
    public void shouldThrowEmptyFileException() throws ParseException {
        //given
        String path = "src\\test\\files\\empty_file.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectQuestionFormatException.class)
    public void shouldThrowIncorrectQuestionFormatExceptionWhenIsNoQuestions() throws ParseException {
        //given
        String path = "src\\test\\files\\empty_questions_array.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectQuestionFormatException.class)
    public void shouldThrowIncorrectQuestionFormatExceptionWhenQuestionIsEmpty() throws ParseException {
        //given
        String path = "src\\test\\files\\empty_question_value.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenIsNoAnswers() throws ParseException {
        //given
        String path = "src\\test\\files\\empty_answers_array.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenIsOnlyOneAnswer() throws ParseException {
        //given
        String path = "src\\test\\files\\only_one_answer.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenAnswerIsEmpty() throws ParseException {
        //given
        String path = "src\\test\\files\\empty_answer_value.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenAllAnswersAreIncorrect() throws ParseException {
        //given
        String path = "src\\test\\files\\only_incorrect_answers.yml";
        YamlParser parser = new YamlParser(path);
        //when
        parser.parse();
    }

    @Test
    public void shouldParseWholeFileIfFileIsInCorrectFormat() throws ParseException {
        //given
        String path = "src\\test\\files\\correct_file.yml";
        YamlParser parser = new YamlParser(path);
        //when
        QuestionsSet questions = parser.parse();
        //then
        assertEquals(2, questions.getQuestions().size());
        assertEquals(2, questions.getQuestions().get(0).getAnswers().size());
        assertEquals(4, questions.getQuestions().get(1).getAnswers().size());
    }

}