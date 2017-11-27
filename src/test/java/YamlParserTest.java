import model.QuestionsSet;
import org.junit.Test;

import static org.junit.Assert.*;

public class YamlParserTest {
    @Test
    public void parse() throws Exception {
        //given
        String path = "src\\test\\files\\test.yml";
        YamlParser parser = new YamlParser(path);
        //when
        QuestionsSet questions = parser.parse();
        //then
        assertEquals(2, questions.getQuestions().size());
        assertEquals(2, questions.getQuestions().get(0).getAnswers().size());
        assertEquals(4, questions.getQuestions().get(1).getAnswers().size());
    }

}