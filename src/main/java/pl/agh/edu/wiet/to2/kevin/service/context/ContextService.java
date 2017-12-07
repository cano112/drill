package pl.agh.edu.wiet.to2.kevin.service.context;

import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;

import java.util.List;

public interface ContextService {
    void setTest(String testFilePath);
    AppContext getContext();
    List<Question> getQuestions();
    int getQuestionsCount();
    int getCurrentQuestionIndex();
    void setCurrentQuestionIndex(int index);
    String getTestFileName();
}
