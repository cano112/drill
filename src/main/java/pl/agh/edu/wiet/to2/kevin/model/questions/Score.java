package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;

public class Score {

    @FXML
    private DoubleProperty scoreValue;

    public Score(Double score) {
        this.scoreValue = new SimpleDoubleProperty(score);
    }

    public double getScoreValue() {
        return scoreValue.get();
    }

    public DoubleProperty scoreValueProperty() {
        return scoreValue;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue.set(scoreValue);
    }
}
