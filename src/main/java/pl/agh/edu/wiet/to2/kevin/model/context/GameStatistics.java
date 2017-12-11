package pl.agh.edu.wiet.to2.kevin.model.context;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;

public class GameStatistics {

    @FXML
    private DoubleProperty points;

    @FXML
    private IntegerProperty correctAnswers;

    @FXML
    private IntegerProperty partiallyCorrectAnswers;

    @FXML
    private IntegerProperty wrongAnswers;

    public GameStatistics() {
        points = new SimpleDoubleProperty(0);
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

    public double getPoints() {
        return points.get();
    }

    public DoubleProperty pointsProperty() {
        return points;
    }

    public void setPoints(double points) {
        this.points.set(points);
    }

    public void incCorrectAnswers() {
        this.correctAnswers.set(this.correctAnswers.get() + 1);
    }

    public void incPartiallyCorrectAnswers() {
        this.partiallyCorrectAnswers.set(this.partiallyCorrectAnswers.get() + 1);
    }

    public void incWrongAnswers() {
        this.wrongAnswers.set(this.wrongAnswers.get() + 1);
    }

    public void addPoints(Double points) {
        this.points.set(this.points.get() + points);
    }
}
