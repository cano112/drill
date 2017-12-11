package pl.agh.edu.wiet.to2.kevin.model.questions;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;

public class Score {

    @FXML
    private DoubleProperty scoreValue;

    @FXML
    private DoubleProperty maxValue;

    public Score(Double scoreValue, Double maxValue) {
        this.scoreValue = new SimpleDoubleProperty(scoreValue);
        this.maxValue = new SimpleDoubleProperty(maxValue);
    }

    public double getMaxValue() {
        return maxValue.get();
    }

    public DoubleProperty maxValueProperty() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue.set(maxValue);
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
