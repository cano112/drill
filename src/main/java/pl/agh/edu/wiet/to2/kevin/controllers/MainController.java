package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.exceptions.IncoherentStateException;
import pl.agh.edu.wiet.to2.kevin.model.context.GameStatistics;
import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.stats.StatsService;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
@Scope("prototype")
public class MainController extends BaseController {

    private final ContextService contextService;
    private final ViewResolver viewResolver;
    private final StatsService statsService;

    private ScoringStrategy scoringStrategy;
    private QuestionChoiceStrategy questionChoiceStrategy;

    @FXML
    private ListView<Answer> answersListView;

    @FXML
    private ObjectProperty<Question> currentQuestion;

    @FXML
    private ObjectProperty<GameStatistics> gameStatistics;

    @Autowired
    public MainController(ContextService contextService, ViewResolver viewResolver, StatsService statsService) {
        this.contextService = contextService;
        this.viewResolver = viewResolver;
        this.statsService = statsService;

        this.currentQuestion = new SimpleObjectProperty<>(new Question("", new ArrayList<>()));
        this.answersListView = new ListView<>();
        this.gameStatistics = new SimpleObjectProperty<>(new GameStatistics());
    }

    @FXML
    private void initialize() {
        this.answersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.scoringStrategy = contextService.getScoringStrategy()
                .orElseThrow(() -> new IncoherentStateException("No scoring strategy set"));

        this.questionChoiceStrategy = contextService.getQuestionChoiceStrategy()
                .orElseThrow(() -> new IncoherentStateException("No question choice strategy set"));

        answersListView.setItems(getCurrentQuestion().getAnswers());
        gameStatistics.set(contextService.getGameStatistics());

        contextService.getContext().testProperty().addListener(observable ->
                currentQuestion.set(getNextQuestion()));
        currentQuestionProperty().addListener((observable, oldValue, newValue) ->
                answersListView.setItems(newValue.getAnswers()));

        currentQuestion.set(getNextQuestion());
    }

    public void onNextButtonClicked(ActionEvent actionEvent) {

        AnsweredQuestion answeredQuestion = new AnsweredQuestion(currentQuestion.get(),
                new HashSet<>(answersListView.getSelectionModel().getSelectedItems()));

        StatsChange statsChange = scoringStrategy.parseStatsChange(answeredQuestion);
        statsService.applyChangeToContext(statsChange);

        // TODO when no question show summary
        Question question = questionChoiceStrategy.getNextQuestion().orElse(new Question("", new ArrayList<>()));
        if (question.getQuestion().equals("")) {
            viewResolver.showView(getStage().orElse(new Stage()), "summaryView");
        } else
            setCurrentQuestion(question);
    }

    public void onMenuButtonClicked(ActionEvent actionEvent) {
        viewResolver.showView(getStage().orElse(new Stage()), "menuView");
    }

    public void onResetButtonClicked(ActionEvent actionEvent) {
        contextService.resetToDefault();
        initialize();
    }

    public Question getCurrentQuestion() {
        return currentQuestion.get();
    }

    public ObjectProperty<Question> currentQuestionProperty() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion.set(currentQuestion);
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

    private Question getNextQuestion() {
        // TODO when no question show summary
        return questionChoiceStrategy.getNextQuestion().orElse(new Question("", new ArrayList<>()));
    }
}
