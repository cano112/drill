package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;

import java.util.Set;

public class AnsweredQuestion {

    @FXML private final ObjectProperty<Question> question;

    @FXML private final ObservableSet<Answer> answersMarked;

    @FXML private final ObjectProperty<QuestionFeedback> feedback;

    public AnsweredQuestion(Question question, Set<Answer> answersMarked, int feedbackValue) {
        this.question = new SimpleObjectProperty<>(question);
        this.answersMarked = FXCollections.observableSet(answersMarked);
        this.feedback = new SimpleObjectProperty<>(new QuestionFeedback(feedbackValue));
    }

    public ObservableSet<Answer> getAnswersMarked() {
        return answersMarked;
    }

    public QuestionFeedback getFeedback() {
        return feedback.get();
    }

    public ObjectProperty<QuestionFeedback> feedbackProperty() {
        return feedback;
    }

    public Question getQuestion() {
        return question.get();
    }

    public ObjectProperty<Question> questionProperty() {
        return question;
    }
}
