package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.impl;

import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;

import java.util.Optional;

public class RandomQuestionStrategy implements QuestionChoiceStrategy {

    private static final String STRATEGY_NAME = "Random question strategy";

    @Override
    public Optional<Question> getNextQuestion() {

        //TODO implement
        return Optional.empty();
    }

    @Override
    public String getName() {
        return STRATEGY_NAME;
    }
}
