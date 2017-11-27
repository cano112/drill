package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.exceptions.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.Configuration;

public interface ConfigurationParser {
    Configuration parse(String path) throws ParseException;
}
