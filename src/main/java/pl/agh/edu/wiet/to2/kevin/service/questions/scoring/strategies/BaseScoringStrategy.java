package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.Score;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;

public abstract class BaseScoringStrategy implements ScoringStrategy {

    private final boolean zeroOnError;
    private final boolean resultCanBeNegative;
    private final boolean fractionalPoints;
    private final double pointsForCorrectAnswer;
    private final double pointsForWrongAnswer;
    private final String strategyName;

    public BaseScoringStrategy(boolean zeroOnError, boolean resultCanBeNegative, boolean fractionalPoints,
            double pointsFactorForCorrectAnswer, double pointsFactorForWrongAnswer, String strategyName) {
        this.zeroOnError = zeroOnError;
        this.resultCanBeNegative = resultCanBeNegative;
        this.fractionalPoints = fractionalPoints;
        this.pointsForCorrectAnswer = pointsFactorForCorrectAnswer;
        this.pointsForWrongAnswer = pointsFactorForWrongAnswer;
        this.strategyName = strategyName;
    }

    @Override
    public Score getScore(AnsweredQuestion answeredQuestion) {
        int correctAnswers = 0;
        int wrongAnswers = 0;
        int maxAnswers = 0;
        for (Answer answer : answeredQuestion.getAnswersMarked()) {
            if (answer.isCorrect()) correctAnswers++;
            else wrongAnswers++;
        }

        for (Answer answer : answeredQuestion.getQuestion().getAnswers()) {
            if (answer.isCorrect()) maxAnswers++;
        }

        double pointsFactor = 1.0;
        if (fractionalPoints) pointsFactor /= maxAnswers;

        double earnedPoints = pointsFactor * correctAnswers * pointsForCorrectAnswer
                + pointsFactor * wrongAnswers * pointsForWrongAnswer;
        double allPoints = pointsFactor * maxAnswers * pointsForCorrectAnswer;

        if ((zeroOnError && wrongAnswers > 0) || (!resultCanBeNegative && earnedPoints < 0))
            earnedPoints = 0.0;

        return new Score(earnedPoints, allPoints);
    }

    @Override
    public StatsChange parseStatsChange(Score score) {
        return new StatsChange(score.getScoreValue(),
                Math.abs(score.getScoreValue() - score.getMaxValue()) < 10e-5,
                Math.abs(score.getScoreValue() - score.getMaxValue()) > 10e-5 && score.getScoreValue() > 0,
                score.getScoreValue() <= 0);
    }

    @Override public String getName() {
        return strategyName;
    }
}
