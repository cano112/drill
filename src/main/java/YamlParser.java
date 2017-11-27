import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import exception.EmptyFileException;
import exception.IncorrectAnswerFormatException;
import exception.IncorrectQuestionFormatException;
import exception.ParseException;
import model.Answer;
import model.Question;
import model.QuestionsSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class YamlParser {
    private final String path;

    public YamlParser(String path) {
        this.path = path;
    }

    public QuestionsSet parse() throws exception.ParseException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(path);
        QuestionsSet questions = null;
        try {
            questions = mapper.readValue(file, QuestionsSet.class);
        } catch (FileNotFoundException e) {
            throw new exception.FileNotFoundException();
        } catch (MismatchedInputException e) {
            throw new EmptyFileException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        validateFormat(questions);
        return questions;
    }

    private void validateFormat(QuestionsSet questionsSet) throws ParseException {
        List<Question> questions = questionsSet.getQuestions();
        if (questions.size() == 0)
            throw new IncorrectQuestionFormatException();

        for (Question question : questions) {
            if (question.getQuestion() == null)
                throw new IncorrectQuestionFormatException();

            List<Answer> answers = question.getAnswers();
            if (answers.size() < 2)
                throw new IncorrectAnswerFormatException();

            boolean isCorrect = false;
            for (Answer answer : answers) {
                if (answer.getAnswer() == null)
                    throw new IncorrectAnswerFormatException();

                if (answer.isCorrect())
                    isCorrect = true;
            }
            if (!isCorrect)
                throw new IncorrectAnswerFormatException();
        }
    }
}
