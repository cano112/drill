package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.BaseQuestionChoiceStrategy;

@Service @Qualifier("hardQuestionsAgainStrategy") @Scope("singleton") public final class HardQuestionsAgainStrategy
        extends BaseQuestionChoiceStrategy {

    private static final String STRATEGY_NAME = "Hard questions back to queue";

    public HardQuestionsAgainStrategy(ContextService contextService) {
        super(contextService, STRATEGY_NAME);
    }

    @Override public void onNextQuestion(AnsweredQuestion answeredQuestion) {
        if (answeredQuestion.getFeedback().getMark() < 2) {
            contextService.addToQuestionQueue(answeredQuestion.getQuestion());
        }
    }
}
