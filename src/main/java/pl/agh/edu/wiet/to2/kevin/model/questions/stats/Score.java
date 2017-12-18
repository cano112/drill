package pl.agh.edu.wiet.to2.kevin.model.questions.stats;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;

public final class Score {

    @FXML private final DoubleProperty scoreValue;

    @FXML private final DoubleProperty maxValue;

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

    public double getScoreValue() {
        return scoreValue.get();
    }

    public DoubleProperty scoreValueProperty() {
        return scoreValue;
    }

}
