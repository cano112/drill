package pl.agh.edu.wiet.to2.kevin.model.context;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;

import java.math.BigDecimal;

public final class GameStatistics {

    @FXML
    private ObjectProperty<BigDecimal> points;

    @FXML
    private IntegerProperty correctAnswers;

    @FXML
    private IntegerProperty partiallyCorrectAnswers;

    @FXML
    private IntegerProperty wrongAnswers;

    public GameStatistics() {
        points = new SimpleObjectProperty<>(BigDecimal.valueOf(0));
        correctAnswers = new SimpleIntegerProperty(0);
        partiallyCorrectAnswers = new SimpleIntegerProperty(0);
        wrongAnswers = new SimpleIntegerProperty(0);
    }

    public int getCorrectAnswers() {
        return correctAnswers.get();
    }

    public IntegerProperty correctAnswersProperty() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers.set(correctAnswers);
    }

    public int getPartiallyCorrectAnswers() {
        return partiallyCorrectAnswers.get();
    }

    public IntegerProperty partiallyCorrectAnswersProperty() {
        return partiallyCorrectAnswers;
    }

    public void setPartiallyCorrectAnswers(int partiallyCorrectAnswers) {
        this.partiallyCorrectAnswers.set(partiallyCorrectAnswers);
    }

    public int getWrongAnswers() {
        return wrongAnswers.get();
    }

    public IntegerProperty wrongAnswersProperty() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers.set(wrongAnswers);
    }

    public BigDecimal getPoints() {
        return points.get();
    }

    public ObjectProperty<BigDecimal> pointsProperty() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points.set(points);
    }
}
