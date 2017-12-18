package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class Question {

    @FXML private final StringProperty question;

    @FXML private final ObservableList<Answer> answers;

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

    public ObservableList<Answer> getAnswers() {
        return answers;
    }

    public ObservableList<Answer> getCorrectAnswers() {
        return answers.filtered(Answer::isCorrect);
    }

    public static Question empty() {
        return new Question("", new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        return question.equals(question1.question) && answers.equals(question1.answers);
    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + answers.hashCode();
        return result;
    }
}

