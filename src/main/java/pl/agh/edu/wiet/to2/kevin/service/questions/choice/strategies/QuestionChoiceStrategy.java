package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies;

import pl.agh.edu.wiet.to2.kevin.model.questions.AnsweredQuestion;

public interface QuestionChoiceStrategy {

    void initialize();

    void onNextQuestion(AnsweredQuestion answeredQuestion);

    String getName();
}
