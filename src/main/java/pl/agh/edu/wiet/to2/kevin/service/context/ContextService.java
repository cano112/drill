package pl.agh.edu.wiet.to2.kevin.service.context;

import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;

import java.util.List;
import java.util.Optional;

public interface ContextService {
    void setTest(String testFilePath);
    AppContext getContext();
    List<Question> getQuestions();
    int getQuestionsCount();
    int getCurrentQuestionIndex();
    void setCurrentQuestionIndex(int index);
    Optional<String> getTestFileName();
}
