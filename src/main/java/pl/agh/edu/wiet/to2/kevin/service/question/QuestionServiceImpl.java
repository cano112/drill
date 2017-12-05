package pl.agh.edu.wiet.to2.kevin.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final ContextService contextService;

    @Autowired
    public QuestionServiceImpl(ContextService contextService) {
        this.contextService = contextService;
    }

    @Override
    public Question getNextQuestion() {
        int questionsCount = contextService.getQuestionsCount();
        int index = contextService.getCurrentQuestionIndex();

        if(questionsCount == 0) {
            return new Question("Placeholder question", new ArrayList<>());
        }

        contextService.setCurrentQuestionIndex((index + 1) % questionsCount);
        return contextService.getQuestions().get((index + 1) % questionsCount);
    }
}
