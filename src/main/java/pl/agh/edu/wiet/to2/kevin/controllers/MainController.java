package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.AppContext;
import pl.agh.edu.wiet.to2.kevin.AppContextImpl;
import pl.agh.edu.wiet.to2.kevin.model.Answer;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.question.QuestionService;

@Controller
@Scope("prototype")
public class MainController {

    private final AppContext appContext;
    private final QuestionService questionService;

    @FXML
    private ListView<Answer> answersListView;

    @FXML
    private ObjectProperty<Question> currentQuestion;

    @Autowired
    public MainController(AppContextImpl appContext, QuestionService questionService) {
        this.appContext = appContext;
        this.questionService = questionService;
        this.currentQuestion = new SimpleObjectProperty<>(questionService.getNextQuestion());
        this.answersListView = new ListView<>();
    }

    @FXML
    private void initialize() {
        answersListView.setItems(getCurrentQuestion().getAnswers());

        appContext.configurationProperty().addListener(observable -> {
            Question question = questionService.getNextQuestion();
            currentQuestion.set(question);
        });

        currentQuestionProperty().addListener((observable, oldValue, newValue) -> {
            answersListView.setItems(newValue.getAnswers());
        });

        // temporary workaround
        appContext.setConfiguration("example.yaml");
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
}