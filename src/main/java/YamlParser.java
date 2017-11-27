import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import model.QuestionsSet;

import java.io.File;
import java.io.IOException;

public class YamlParser {
    private final String path;

    public YamlParser(String path) {
        this.path = path;
    }

    public QuestionsSet parse() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(path);
        QuestionsSet questions = null;
        try {
            questions = mapper.readValue(file, QuestionsSet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
