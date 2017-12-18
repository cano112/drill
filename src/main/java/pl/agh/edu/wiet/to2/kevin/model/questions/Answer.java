package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public final class Answer {

    @FXML private final StringProperty answer;

    @FXML private final BooleanProperty correct;

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

    public String getAnswer() {
        return answer.get();
    }

    public StringProperty answerProperty() {
        return answer;
    }

    @Override
    public String toString() {
        return answer.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        return answer.equals(answer1.answer) && correct.equals(answer1.correct);
    }

    @Override
    public int hashCode() {
        int result = answer.hashCode();
        result = 31 * result + correct.hashCode();
        return result;
    }
}
