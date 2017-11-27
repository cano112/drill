package pl.agh.edu.wiet.to2.kevin;

import pl.agh.edu.wiet.to2.kevin.exceptions.ParseException;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.model.Configuration;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.parser.ConfigurationParser;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class AppContextImpl implements AppContext {

    private StringProperty pathToConfigurationFile;
    private ObjectProperty<Configuration> configuration;
    private IntegerProperty currentQuestionIndex;
    private ObservableList<Question> questions;

    private ConfigurationParser configurationParser;

    @Autowired
    public AppContextImpl(ConfigurationParser configurationParser) {
        this.configurationParser = configurationParser;

        this.pathToConfigurationFile = new SimpleStringProperty("");
        this.configuration = new SimpleObjectProperty<>(new Configuration(new ArrayList<>()));
        this.currentQuestionIndex = new SimpleIntegerProperty(-1);
        this.questions = FXCollections.observableList(new ArrayList<>());
    }

    public String getPathToConfigurationFile() {
        return pathToConfigurationFile.get();
    }

    public Configuration getConfiguration() {
        return configuration.get();
    }

    public void setConfiguration(String configurationFilePath) {
        this.pathToConfigurationFile.set(configurationFilePath);
        parseFile();
        resetToDefault();
    }

    public ObjectProperty<Configuration> configurationProperty() {
        return configuration;
    }

    public StringProperty pathToConfigurationFileProperty() {
        return pathToConfigurationFile;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex.get();
    }

    public IntegerProperty currentQuestionIndexProperty() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex.set(currentQuestionIndex);
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions.setAll(questions);
    }

    private void parseFile() {
        try {
            configuration.set(configurationParser.parse(pathToConfigurationFile.get()));
        } catch (ParseException e) {
            configuration.set(new Configuration(new ArrayList<>()));
        }
    }

    private void resetToDefault() {
        setCurrentQuestionIndex(-1);
        setQuestions(getConfiguration().getQuestions());
    }
}
