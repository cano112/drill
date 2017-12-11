package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.exceptions.parser.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;

public interface TestParsingService {
    Test parse(String path) throws ParseException;
}
