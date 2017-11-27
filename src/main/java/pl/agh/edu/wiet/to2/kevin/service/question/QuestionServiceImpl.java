package pl.agh.edu.wiet.to2.kevin.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.AppContextImpl;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.service.parser.dto.QuestionDTO;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final AppContextImpl appContext;

    @Autowired
    public QuestionServiceImpl(AppContextImpl appContext) {
        this.appContext = appContext;
    }

    @Override
    public Question getNextQuestion() {
        int questionsCount = appContext.getConfiguration().getQuestions().size();
        int index = appContext.getCurrentQuestionIndex();

        if(questionsCount == 0) {
            return new Question("Placeholder question", new ArrayList<>());
        }

        appContext.setCurrentQuestionIndex((index + 1) % questionsCount);
        return appContext.getConfiguration().getQuestions().get((index + 1) % questionsCount);
    }
}
