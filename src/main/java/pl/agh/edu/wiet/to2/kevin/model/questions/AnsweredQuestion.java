package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;

import java.util.List;
import java.util.Set;

public class AnsweredQuestion extends Question {

    @FXML
    private ObservableSet<Answer> answersMarked;

    public AnsweredQuestion(String question, List<Answer> answers, Set<Answer> answersMarked) {
        super(question, answers);
        this.answersMarked = FXCollections.observableSet(answersMarked);
    }

    public ObservableSet<Answer> getAnswersMarked() {
        return answersMarked;
    }

    public void setAnswersMarked(ObservableSet<Answer> answersMarked) {
        this.answersMarked = answersMarked;
    }
}
