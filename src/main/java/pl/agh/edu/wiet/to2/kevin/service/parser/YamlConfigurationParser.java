package pl.agh.edu.wiet.to2.kevin.service.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import pl.agh.edu.wiet.to2.kevin.exceptions.MismatchedInputException;
import pl.agh.edu.wiet.to2.kevin.exceptions.IncorrectAnswerFormatException;
import pl.agh.edu.wiet.to2.kevin.exceptions.IncorrectQuestionFormatException;
import pl.agh.edu.wiet.to2.kevin.exceptions.ParseException;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.Answer;
import pl.agh.edu.wiet.to2.kevin.model.Configuration;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.parser.dto.AnswerDTO;
import pl.agh.edu.wiet.to2.kevin.service.parser.dto.ConfigurationDTO;
import pl.agh.edu.wiet.to2.kevin.service.parser.dto.QuestionDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YamlConfigurationParser implements ConfigurationParser {

    public Configuration parse(String path) throws ParseException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(path);
        ConfigurationDTO dto = null;
        try {
            dto = mapper.readValue(file, ConfigurationDTO.class);
        } catch (FileNotFoundException e) {
            throw new pl.agh.edu.wiet.to2.kevin.exceptions.FileNotFoundException();
        } catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e) {
            throw new MismatchedInputException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        validateFormat(dto);
        return mapDtoToDomain(dto);
    }

    private Configuration mapDtoToDomain(ConfigurationDTO dto) {
        return new Configuration(dto.getQuestions()
                .stream()
                .map(questionDTO ->
                        new Question(questionDTO.getQuestion(),
                                questionDTO.getAnswers()
                                        .stream()
                                        .map(answerDTO -> new Answer(answerDTO.getAnswer(), answerDTO.isCorrect()))
                                        .collect(Collectors.toList())))
                .collect(Collectors.toList()));
    }

    private void validateFormat(ConfigurationDTO dto) throws ParseException {
        List<QuestionDTO> questions = dto.getQuestions();
        if (questions.size() == 0)
            throw new IncorrectQuestionFormatException();

        for (QuestionDTO question : questions) {
            if (question.getQuestion() == null)
                throw new IncorrectQuestionFormatException();

            List<AnswerDTO> answers = question.getAnswers();
            if (answers.size() < 2)
                throw new IncorrectAnswerFormatException();

            boolean isCorrect = false;
            for (AnswerDTO answer : answers) {
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
