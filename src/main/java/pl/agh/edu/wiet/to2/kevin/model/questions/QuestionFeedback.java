package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;

public final class QuestionFeedback {

    @FXML private final IntegerProperty mark;

    public QuestionFeedback(int markValue) {
        this.mark = new SimpleIntegerProperty(markValue);
    }

    public int getMark() {
        return mark.get();
    }

    public IntegerProperty markProperty() {
        return mark;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        QuestionFeedback that = (QuestionFeedback) o;

        return mark.equals(that.mark);
    }

    @Override public int hashCode() {
        return mark.hashCode();
    }
}
