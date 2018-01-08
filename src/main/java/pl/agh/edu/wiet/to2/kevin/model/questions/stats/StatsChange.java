package pl.agh.edu.wiet.to2.kevin.model.questions.stats;

import java.math.BigDecimal;

public final class StatsChange {
    private final BigDecimal points;
    private final boolean correct;
    private final boolean partiallyCorrect;
    private final boolean wrong;

    public StatsChange(BigDecimal points, boolean correct, boolean partiallyCorrect, boolean wrong) {
        this.points = points;
        this.correct = correct;
        this.partiallyCorrect = partiallyCorrect;
        this.wrong = wrong;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public boolean isCorrect() {
        return correct;
    }

    public boolean isPartiallyCorrect() {
        return partiallyCorrect;
    }

    public boolean isWrong() {
        return wrong;
    }
}
