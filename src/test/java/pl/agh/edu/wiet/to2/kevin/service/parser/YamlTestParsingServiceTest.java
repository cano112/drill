package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.exceptions.parser.*;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;

import static org.junit.Assert.*;

public class YamlTestParsingServiceTest {

    @org.junit.Test(expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundException() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\file_not_found.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = MismatchedInputException.class)
    public void shouldThrowMismatchedInputExceptionWhenFileIsEmpty() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\empty_file.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = MismatchedInputException.class)
    public void shouldThrowMismatchedInputExceptionWhenFileHasRandomContent() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\file_with_random_content.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = MismatchedInputException.class)
    public void shouldThrowMismatchedInputExceptionWhenFileHaveRandomYamlLikeContent() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\file_with_random_yaml_content.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = MismatchedInputException.class)
    public void shouldThrowMismatchedInputExceptionWhenFileHaveSomeAdditionalYamlContent() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\file_with_additional_random_yaml_content.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectQuestionFormatException.class)
    public void shouldThrowIncorrectQuestionFormatExceptionWhenIsNoQuestions() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\empty_questions_array.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectQuestionFormatException.class)
    public void shouldThrowIncorrectQuestionFormatExceptionWhenQuestionIsEmpty() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\empty_question_value.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenIsNoAnswers() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\empty_answers_array.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenIsOnlyOneAnswer() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\only_one_answer.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenAnswerIsEmpty() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\empty_answer_value.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test(expected = IncorrectAnswerFormatException.class)
    public void shouldThrowIncorrectAnswerFormatExceptionWhenAllAnswersAreIncorrect() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\only_incorrect_answers.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        parser.parse(path);
    }

    @org.junit.Test
    public void shouldParseWholeFileIfFileIsInCorrectFormat() throws ParseException {
        //given
        String path = "src\\test\\resources\\files\\correct_file.yml";
        YamlTestParsingService parser = new YamlTestParsingService();
        //when
        Test test = parser.parse(path);
        //then
        assertEquals(2, test.getQuestions().size());
        assertEquals(2, test.getQuestions().get(0).getAnswers().size());
        assertEquals(4, test.getQuestions().get(1).getAnswers().size());
    }

}