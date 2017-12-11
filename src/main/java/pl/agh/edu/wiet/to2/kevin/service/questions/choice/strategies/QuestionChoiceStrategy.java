package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.Question;

import java.util.Optional;

public interface QuestionChoiceStrategy {

    Optional<Question> getNextQuestion();

    String getName();
}
