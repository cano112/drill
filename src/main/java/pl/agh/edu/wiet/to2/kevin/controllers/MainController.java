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
import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.QuestionService;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

@Controller
@Scope("prototype")
public class MainController extends BaseController {

    private final ContextService contextService;
    private final QuestionService questionService;
    private final ViewResolver viewResolver;

    @FXML
    private ListView<Answer> answersListView;

    @FXML
    private ObjectProperty<Question> currentQuestion;

    @Autowired
    public MainController(ContextService contextService, QuestionService questionService, ViewResolver viewResolver) {
        this.contextService = contextService;
        this.questionService = questionService;
        this.viewResolver = viewResolver;
        this.currentQuestion = new SimpleObjectProperty<>(questionService.getNextQuestion());
        this.answersListView = new ListView<>();
    }

    @FXML
    private void initialize() {
        answersListView.setItems(getCurrentQuestion().getAnswers());

        contextService.getContext().testProperty().addListener(observable -> {
            Question question = questionService.getNextQuestion();
            currentQuestion.set(question);
        });

        currentQuestionProperty().addListener((observable, oldValue, newValue) -> {
            answersListView.setItems(newValue.getAnswers());
        });

        // temporary workaround
        contextService.setTest("example.yaml");
        setCurrentQuestion(questionService.getNextQuestion());
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
        setCurrentQuestion(questionService.getNextQuestion());
    }

    public void onMenuButtonClicked(ActionEvent actionEvent) {
        viewResolver.showView(getStage().orElse(new Stage()), "menuView");
    }
}
