package pl.agh.edu.wiet.to2.kevin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

public class Configuration {

    @FXML
    private ObservableList<Question> questions;

    public Configuration(List<Question> questions) {
        this.questions = FXCollections.observableList(questions);
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions.setAll(questions);
    }
}
