package pl.agh.edu.wiet.to2.kevin.model.questions.stats;

public class StatsChange {
    private final double points;
    private final boolean correct;
    private final boolean partiallyCorrect;
    private final boolean wrong;

    public StatsChange(double points, boolean correct, boolean partiallyCorrect, boolean wrong) {
        this.points = points;
        this.correct = correct;
        this.partiallyCorrect = partiallyCorrect;
        this.wrong = wrong;
    }

    public double getPoints() {
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
