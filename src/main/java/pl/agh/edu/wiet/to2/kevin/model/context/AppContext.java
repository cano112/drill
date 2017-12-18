package pl.agh.edu.wiet.to2.kevin.model.context;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
@Scope("singleton") public final class AppContext {

    private StringProperty pathToTestFile;
    private ObjectProperty<Test> test;
    private ObservableList<Question> questions;
    private StringProperty scoringStrategy;
    private StringProperty questionChoiceStrategy;
    private ObjectProperty<GameStatistics> gameStatistics;
    private ObjectProperty<Queue<Question>> questionsQueue;

    public AppContext() {
        this.pathToTestFile = new SimpleStringProperty("");
        this.test = new SimpleObjectProperty<>(new Test(new ArrayList<>()));
        this.questions = FXCollections.observableList(new ArrayList<>());
        this.scoringStrategy = new SimpleStringProperty("");
        this.questionChoiceStrategy = new SimpleStringProperty("");
        this.gameStatistics = new SimpleObjectProperty<>(new GameStatistics());
        this.questionsQueue = new SimpleObjectProperty<>(new LinkedList<>());
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

    public GameStatistics getGameStatistics() {
        return gameStatistics.get();
    }

    public ObjectProperty<GameStatistics> gameStatisticsProperty() {
        return gameStatistics;
    }

    public void setGameStatistics(GameStatistics gameStatistics) {
        this.gameStatistics.set(gameStatistics);
    }

    public Queue<Question> getQuestionsQueue() {
        return questionsQueue.get();
    }

    public void setQuestionsQueue(Queue<Question> questionsQueue) {
        this.questionsQueue.set(questionsQueue);
    }

    public ObjectProperty<Queue<Question>> questionsQueueProperty() {
        return questionsQueue;
    }
}
