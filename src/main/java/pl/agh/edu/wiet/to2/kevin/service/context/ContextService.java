package pl.agh.edu.wiet.to2.kevin.service.context;

import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.model.context.GameStatistics;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

import java.util.List;
import java.util.Optional;

public interface ContextService {

    AppContext getContext();

    List<Question> getQuestions();
    int getQuestionsCount();
    GameStatistics getGameStatistics();

    Optional<String> getTestFileName();
    void setTest(String testFilePath);

    int getCurrentQuestionIndex();
    void setCurrentQuestionIndex(int index);

    void setScoringStrategyName(String scoringStrategy);
    Optional<String> getScoringStrategyName();
    Optional<ScoringStrategy> getScoringStrategy();

    void setQuestionChoiceStrategyName(String questionChoiceStrategy);
    Optional<String> getQuestionChoiceStrategyName();
    Optional<QuestionChoiceStrategy> getQuestionChoiceStrategy();

    void resetToDefault();
}
