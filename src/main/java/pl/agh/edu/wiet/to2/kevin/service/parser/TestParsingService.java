package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.exceptions.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.Test;

public interface TestParsingService {
    Test parse(String path) throws ParseException;
}
