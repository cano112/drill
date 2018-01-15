package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.Score;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;

import java.math.BigDecimal;

public abstract class BaseScoringStrategy implements ScoringStrategy {

    private final boolean zeroOnError;
    private final boolean resultCanBeNegative;
    private final boolean fractionalPoints;
    private final BigDecimal pointsForCorrectAnswer;
    private final BigDecimal pointsForWrongAnswer;
    private final String strategyName;

    public BaseScoringStrategy(boolean zeroOnError, boolean resultCanBeNegative, boolean fractionalPoints,
                               BigDecimal pointsFactorForCorrectAnswer, BigDecimal pointsFactorForWrongAnswer, String strategyName) {
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

        BigDecimal pointsFactor = BigDecimal.valueOf(1.0);
        if (fractionalPoints) pointsFactor = pointsFactor.divide(BigDecimal.valueOf(maxAnswers));

        BigDecimal earnedPoints = pointsFactor.multiply(pointsForCorrectAnswer).multiply(BigDecimal.valueOf(correctAnswers))
                .add(pointsFactor.multiply(pointsForWrongAnswer).multiply(BigDecimal.valueOf(wrongAnswers)));
        BigDecimal allPoints = pointsFactor.multiply(pointsForCorrectAnswer).multiply(BigDecimal.valueOf(maxAnswers));

        if ((zeroOnError && wrongAnswers > 0) || (!resultCanBeNegative && earnedPoints.compareTo(BigDecimal.ZERO) < 0))
            earnedPoints = BigDecimal.valueOf(0.0);

        return new Score(earnedPoints, allPoints);
    }

    @Override
    public StatsChange parseStatsChange(Score score) {
        return new StatsChange(score.getScoreValue(),
                score.getScoreValue().compareTo(score.getMaxValue()) == 0,
                score.getScoreValue().compareTo(score.getMaxValue()) < 0 && score.getScoreValue().compareTo(BigDecimal.ZERO) > 0,
                score.getScoreValue().compareTo(BigDecimal.ZERO) <= 0);
    }

    @Override
    public String getName() {
        return strategyName;
    }
}
