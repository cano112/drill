package pl.agh.edu.wiet.to2.kevin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import pl.agh.edu.wiet.to2.kevin.model.Configuration;
import pl.agh.edu.wiet.to2.kevin.model.Question;

import java.util.List;

public interface AppContext {

    Configuration getConfiguration();
    void setConfiguration(String configurationFilePath);

    int getCurrentQuestionIndex();
    void setCurrentQuestionIndex(int currentQuestionIndex);

    ObservableList<Question> getQuestions();
    void setQuestions(List<Question> questions);

    ObjectProperty<Configuration> configurationProperty();
    IntegerProperty currentQuestionIndexProperty();
    StringProperty pathToConfigurationFileProperty();
}
