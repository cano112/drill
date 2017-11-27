package pl.agh.edu.wiet.to2.kevin.service.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.Answer;
import pl.agh.edu.wiet.to2.kevin.model.Configuration;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.parser.dto.ConfigurationDTO;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class YamlConfigurationParser implements ConfigurationParser {

    public Configuration parse(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(path);
        ConfigurationDTO dto = mapper.readValue(file, ConfigurationDTO.class);
        Configuration config = mapDtoToDomain(dto);
        return config;
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
}
