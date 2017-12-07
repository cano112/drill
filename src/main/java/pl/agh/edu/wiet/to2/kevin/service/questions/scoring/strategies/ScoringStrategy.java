package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.Score;

public interface ScoringStrategy {
    Score getScore(AnsweredQuestion answeredQuestion);
}
