package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class Answer {

    @FXML
    private StringProperty answer;

    @FXML
    private BooleanProperty correct;

    public Answer(String answer, boolean correct) {
        this.answer = new SimpleStringProperty(answer);
        this.correct = new SimpleBooleanProperty(correct);
    }
    public boolean isCorrect() {
        return correct.get();
    }

    public BooleanProperty correctProperty() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct.set(correct);
    }

    public String getAnswer() {
        return answer.get();
    }

    public StringProperty answerProperty() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.set(answer);
    }

    @Override
    public String toString() {
        return answer.get();
    }
}
