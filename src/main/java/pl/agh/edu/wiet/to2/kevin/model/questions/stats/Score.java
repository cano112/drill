package pl.agh.edu.wiet.to2.kevin.model.questions.stats;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;

import java.math.BigDecimal;

public final class Score {

    @FXML
    private final ObjectProperty<BigDecimal> scoreValue;

    @FXML
    private final ObjectProperty<BigDecimal> maxValue;

    public Score(BigDecimal scoreValue, BigDecimal maxValue) {
        this.scoreValue = new SimpleObjectProperty<>(scoreValue);
        this.maxValue = new SimpleObjectProperty<>(maxValue);
    }

    public BigDecimal getMaxValue() {
        return maxValue.get();
    }

    public ObjectProperty<BigDecimal> maxValueProperty() {
        return maxValue;
    }

    public BigDecimal getScoreValue() {
        return scoreValue.get();
    }

    public ObjectProperty<BigDecimal> scoreValueProperty() {
        return scoreValue;
    }

}
