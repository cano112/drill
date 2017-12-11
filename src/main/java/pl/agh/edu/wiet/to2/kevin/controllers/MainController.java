package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.exceptions.IncoherentStateException;
import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

import java.util.ArrayList;

@Controller
@Scope("prototype")
public class MainController extends BaseController {

    private final ContextService contextService;
    private final ViewResolver viewResolver;

    private ScoringStrategy scoringStrategy;
    private QuestionChoiceStrategy questionChoiceStrategy;

    @FXML
    private ListView<Answer> answersListView;

    @FXML
    private ObjectProperty<Question> currentQuestion;

    @Autowired
    public MainController(ContextService contextService, ViewResolver viewResolver) {
        this.contextService = contextService;
        this.viewResolver = viewResolver;
        this.currentQuestion = new SimpleObjectProperty<>(new Question("", new ArrayList<>()));
        this.answersListView = new ListView<>();
    }

    @FXML
    private void initialize() {
        this.scoringStrategy = contextService.getScoringStrategy()
                .orElseThrow(() -> new IncoherentStateException("No scoring strategy set"));

        this.questionChoiceStrategy = contextService.getQuestionChoiceStrategy()
                .orElseThrow(() -> new IncoherentStateException("No question choice strategy set"));

        answersListView.setItems(getCurrentQuestion().getAnswers());

        contextService.getContext().testProperty().addListener(observable ->
                currentQuestion.set(getNextQuestion()));
        currentQuestionProperty().addListener((observable, oldValue, newValue) ->
                answersListView.setItems(newValue.getAnswers()));

        currentQuestion.set(getNextQuestion());
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

    public void onNextButtonClicked(ActionEvent actionEvent) {

        // TODO when no question show summary
        setCurrentQuestion(questionChoiceStrategy.getNextQuestion()
                .orElse(new Question("", new ArrayList<>())));
    }

    public void onMenuButtonClicked(ActionEvent actionEvent) {
        viewResolver.showView(getStage().orElse(new Stage()), "menuView");
    }

    private Question getNextQuestion() {
        // TODO when no question show summary
        return questionChoiceStrategy.getNextQuestion().orElse(new Question("", new ArrayList<>()));
    }
}
