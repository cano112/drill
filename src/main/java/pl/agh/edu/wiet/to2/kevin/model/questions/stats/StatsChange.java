package pl.agh.edu.wiet.to2.kevin.model.questions.stats;

public class StatsChange {
    private double points;
    private boolean correct;
    private boolean partiallyCorrect;
    private boolean wrong;

    public StatsChange(double points, boolean correct, boolean partiallyCorrect, boolean wrong) {
        this.points = points;
        this.correct = correct;
        this.partiallyCorrect = partiallyCorrect;
        this.wrong = wrong;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isPartiallyCorrect() {
        return partiallyCorrect;
    }

    public void setPartiallyCorrect(boolean partiallyCorrect) {
        this.partiallyCorrect = partiallyCorrect;
    }

    public boolean isWrong() {
        return wrong;
    }

    public void setWrong(boolean wrong) {
        this.wrong = wrong;
    }
}
