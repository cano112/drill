package pl.agh.edu.wiet.to2.kevin.service.context;

import pl.agh.edu.wiet.to2.kevin.model.AppContext;
import pl.agh.edu.wiet.to2.kevin.model.Question;

import java.util.List;

/**
 * Created by student6 on 2017-12-05.
 */
public interface ContextService {
    void setTest(String testFilePath);

    AppContext getContext();
    List<Question> getQuestions();
    int getQuestionsCount();
    int getCurrentQuestionIndex();

    void setCurrentQuestionIndex(int index);
}
