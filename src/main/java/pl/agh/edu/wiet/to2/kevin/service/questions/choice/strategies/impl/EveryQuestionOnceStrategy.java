package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.exceptions.questions.EmptyQuestionListException;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Qualifier("everyQuestionOnceStrategy")
@Scope("singleton")
public class EveryQuestionOnceStrategy implements QuestionChoiceStrategy {

    private final ContextService contextService;

    @Autowired
    public EveryQuestionOnceStrategy(ContextService contextService) {
        this.contextService = contextService;
    }

    @Override
    public Optional<Question> getNextQuestion() {
        int currentIndex = contextService.getCurrentQuestionIndex();
        int questionsCount = contextService.getQuestionsCount();

        if(questionsCount == 0) {
            throw new EmptyQuestionListException("No questions");
        }

        try {
            Question nextQuestion = contextService.getQuestions().get(currentIndex + 1);
            contextService.setCurrentQuestionIndex(currentIndex + 1);
            return Optional.of(nextQuestion);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
