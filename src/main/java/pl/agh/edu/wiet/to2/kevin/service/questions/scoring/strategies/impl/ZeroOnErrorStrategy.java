package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.Score;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

@Service
@Qualifier("zeroOnErrorScoringStrategy")
public class ZeroOnErrorStrategy implements ScoringStrategy {

    @Override
    public Score getScore(AnsweredQuestion answeredQuestion) {
        //TODO implementation
        return null;
    }
}
