package pl.agh.edu.wiet.to2.kevin.model.context;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;
import pl.agh.edu.wiet.to2.kevin.service.parser.TestParsingService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class AppContext {

    private StringProperty pathToTestFile;
    private ObjectProperty<Test> test;
    private IntegerProperty currentQuestionIndex;
    private ObservableList<Question> questions;
    private StringProperty scoringStrategy;
    private StringProperty questionChoiceStrategy;

    public AppContext() {
        this.pathToTestFile = new SimpleStringProperty("");
        this.test = new SimpleObjectProperty<>(new Test(new ArrayList<>()));
        this.currentQuestionIndex = new SimpleIntegerProperty(-1);
        this.questions = FXCollections.observableList(new ArrayList<>());
        this.scoringStrategy = new SimpleStringProperty();
        this.questionChoiceStrategy = new SimpleStringProperty();
    }

    public String getPathToTestFile() {
        return pathToTestFile.get();
    }

    public void setPathToTestFile(String pathToTestFile) {
        this.pathToTestFile.set(pathToTestFile);
    }

    public Test getTest() {
        return test.get();
    }

    public void setTest(Test test) {
        this.test.set(test);
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex.get();
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

    public ObjectProperty<Test> testProperty() {
        return test;
    }

    public StringProperty pathToTestFileProperty() {
        return pathToTestFile;
    }

    public IntegerProperty currentQuestionIndexProperty() {
        return currentQuestionIndex;
    }

    public String getScoringStrategy() {
        return scoringStrategy.get();
    }

    public StringProperty scoringStrategyProperty() {
        return scoringStrategy;
    }

    public void setScoringStrategy(String scoringStrategy) {
        this.scoringStrategy.set(scoringStrategy);
    }

    public String getQuestionChoiceStrategy() {
        return questionChoiceStrategy.get();
    }

    public StringProperty questionChoiceStrategyProperty() {
        return questionChoiceStrategy;
    }

    public void setQuestionChoiceStrategy(String questionChoiceStrategy) {
        this.questionChoiceStrategy.set(questionChoiceStrategy);
    }
}
