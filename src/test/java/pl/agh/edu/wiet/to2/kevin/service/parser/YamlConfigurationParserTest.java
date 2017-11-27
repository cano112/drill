package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.service.parser.dto.ConfigurationDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class YamlConfigurationParserTest {

    @Test
    public void testParse() throws Exception {
        //given
        String path = "src\\test\\files\\test.yml";
        YamlConfigurationParser parser = new YamlConfigurationParser();

        //when
        ConfigurationDTO questions = parser.parse(path);

        //then
        assertEquals(2, questions.getQuestions().size());
        assertEquals(2, questions.getQuestions().get(0).getAnswers().size());
        assertEquals(4, questions.getQuestions().get(1).getAnswers().size());
    }

}