package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

public class Test {

    @FXML
    private ObservableList<Question> questions;

    public Test(List<Question> questions) {
        this.questions = FXCollections.observableList(questions);
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions.setAll(questions);
    }
}
