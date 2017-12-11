package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

public class Question {

    @FXML
    private StringProperty question;

    @FXML
    private ObservableList<Answer> answers;

    public Question(String question, List<Answer> answers) {
        this.question = new SimpleStringProperty(question);
        this.answers = FXCollections.observableList(answers);
    }

    public String getQuestion() {
        return question.get();
    }

    public StringProperty questionProperty() {
        return question;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public ObservableList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers.setAll(answers);
    }
}

