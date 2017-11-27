package pl.agh.edu.wiet.to2.kevin.service.parser;

import pl.agh.edu.wiet.to2.kevin.model.Configuration;

import java.io.IOException;

public interface ConfigurationParser {
    Configuration parse(String path) throws IOException;
}
