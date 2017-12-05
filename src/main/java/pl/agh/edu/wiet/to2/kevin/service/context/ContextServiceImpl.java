package pl.agh.edu.wiet.to2.kevin.service.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.AppContext;
import pl.agh.edu.wiet.to2.kevin.exceptions.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.Question;
import pl.agh.edu.wiet.to2.kevin.model.Test;
import pl.agh.edu.wiet.to2.kevin.service.parser.TestParsingService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContextServiceImpl implements ContextService {

    private final TestParsingService testParsingService;
    private final AppContext appContext;

    @Autowired
    public ContextServiceImpl(TestParsingService testParsingService, AppContext appContext) {
        this.testParsingService = testParsingService;
        this.appContext = appContext;
    }

    @Override
    public void setTest(String testFilePath) {
        appContext.setPathToTestFile(testFilePath);
        parseFile();
        resetToDefault();
    }

    @Override
    public AppContext getContext() {
        return appContext;
    }

    @Override
    public List<Question> getQuestions() {
        return appContext.getQuestions();
    }

    @Override
    public int getQuestionsCount() {
        return appContext.getQuestions().size();
    }

    @Override
    public int getCurrentQuestionIndex() {
        return appContext.getCurrentQuestionIndex();
    }

    @Override
    public void setCurrentQuestionIndex(int index) {
        appContext.setCurrentQuestionIndex(index);
    }

    private void parseFile() {
        try {
            appContext.setTest(testParsingService.parse(appContext.getPathToTestFile()));
        } catch (ParseException e) {
            appContext.setTest(new Test(new ArrayList<>()));
        }
    }

    private void resetToDefault() {
        appContext.setCurrentQuestionIndex(-1);
        appContext.setQuestions(appContext.getTest().getQuestions());
    }
}
