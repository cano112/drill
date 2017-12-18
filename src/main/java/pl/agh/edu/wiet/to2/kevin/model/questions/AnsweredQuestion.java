package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;

import java.util.Set;

public class AnsweredQuestion extends Question {

    @FXML private final ObservableSet<Answer> answersMarked;

    @FXML private final ObjectProperty<QuestionFeedback> feedback;

    public AnsweredQuestion(Question question, Set<Answer> answersMarked) {
        super(question.getQuestion(), question.getAnswers());
        this.answersMarked = FXCollections.observableSet(answersMarked);

        //TODO feedback
        this.feedback = new SimpleObjectProperty<>(new QuestionFeedback(0));
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
}
