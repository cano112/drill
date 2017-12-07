package pl.agh.edu.wiet.to2.kevin.service.context.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.exceptions.parser.MismatchedInputException;
import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.exceptions.parser.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.parser.TestParsingService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public Optional<String> getTestFileName() {
        Pattern pattern = Pattern.compile("[\\\\/]([^\\\\/]*)$");
        Matcher matcher = pattern.matcher(appContext.getPathToTestFile());
        String name = null;
        if(matcher.find()) {
            name = matcher.group(1);
        }
        return Optional.ofNullable(name);
    }
    private void resetToDefault() {
        appContext.setCurrentQuestionIndex(-1);
        appContext.setQuestions(appContext.getTest().getQuestions());
    }
    private void parseFile() {
        try {
            appContext.setTest(testParsingService.parse(appContext.getPathToTestFile()));
        } catch (ParseException e) {
            appContext.setTest(new Test(new ArrayList<>()));
        }
    }


}
