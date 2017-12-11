package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.Score;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

@Service
@Qualifier("zeroOnErrorScoringStrategy")
@Scope("singleton")
public class ZeroOnErrorStrategy implements ScoringStrategy {

    @Override
    public Score getScore(AnsweredQuestion answeredQuestion) {
        //TODO implementation
        return new Score(0.0, 0.0);
    }

    @Override public StatsChange parseStatsChange(Score score) {
        return new StatsChange(0, false, false, false);
    }
}
