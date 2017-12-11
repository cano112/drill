package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.Score;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;

public interface ScoringStrategy {
    Score getScore(AnsweredQuestion answeredQuestion);

    StatsChange parseStatsChange(Score score);

    default StatsChange parseStatsChange(AnsweredQuestion answeredQuestion) {
        return parseStatsChange(getScore(answeredQuestion));
    }

    String getName();
}
