package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.BaseQuestionChoiceStrategy;

@Service @Qualifier("everyQuestionOnceInOrderStrategy") @Scope("singleton") public final class EveryQuestionOnceStrategy
        extends BaseQuestionChoiceStrategy {

    private static final String STRATEGY_NAME = "Just iterate over";

    @Autowired
    public EveryQuestionOnceStrategy(ContextService contextService) {
        super(contextService, STRATEGY_NAME);
    }

    @Override public void onNextQuestion(AnsweredQuestion answeredQuestion) {

    }

    @Override
    public String getName() {
        return STRATEGY_NAME;
    }
}
