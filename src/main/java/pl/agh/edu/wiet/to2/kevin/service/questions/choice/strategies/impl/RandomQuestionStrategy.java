package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.BaseQuestionChoiceStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service @Qualifier("shuffledQuestionsStrategy") @Scope("singleton") public final class RandomQuestionStrategy
        extends BaseQuestionChoiceStrategy {

    private static final String STRATEGY_NAME = "Questions shuffled";

    @Autowired public RandomQuestionStrategy(ContextService contextService) {
        super(contextService, STRATEGY_NAME);
    }

    @Override public void onNextQuestion(AnsweredQuestion answeredQuestion) {

    }

    @Override public void initialize() {
        List<Question> shuffledQuestions = new ArrayList<>(contextService.getQuestions());
        Collections.shuffle(shuffledQuestions);
        contextService.addToQuestionQueue(shuffledQuestions);
    }
}
