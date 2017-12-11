package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;

public class QuestionFeedback {

    @FXML
    private IntegerProperty mark;

    public QuestionFeedback(int markValue) {
        this.mark = new SimpleIntegerProperty(markValue);
    }

    public int getMark() {
        return mark.get();
    }

    public IntegerProperty markProperty() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark.set(mark);
    }
}
