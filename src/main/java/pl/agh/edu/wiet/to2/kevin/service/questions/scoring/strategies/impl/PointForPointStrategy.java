package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.Answer;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.Score;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

@Service
@Qualifier("pointForPointScoringStrategy")
@Scope("singleton")
public class PointForPointStrategy implements ScoringStrategy {

    @Override
    public Score getScore(AnsweredQuestion answeredQuestion) {
        int correctAnswers = 0;
        int wrongAnswers = 0;
        int maxAnswers = 0;
        for(Answer answer : answeredQuestion.getAnswersMarked()) {
            if(answer.isCorrect()) correctAnswers++;
            else wrongAnswers++;
        }

        for(Answer answer : answeredQuestion.getAnswers()) {
            if(answer.isCorrect()) maxAnswers++;
        }

        return new Score((double)(correctAnswers - wrongAnswers), (double)maxAnswers);
    }
}
