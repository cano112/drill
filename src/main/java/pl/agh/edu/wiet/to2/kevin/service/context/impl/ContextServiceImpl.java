package pl.agh.edu.wiet.to2.kevin.service.context.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.exceptions.parser.ParseException;
import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.model.context.GameStatistics;
import pl.agh.edu.wiet.to2.kevin.model.questions.Question;
import pl.agh.edu.wiet.to2.kevin.model.questions.Test;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.parser.TestParsingService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service public final class ContextServiceImpl implements ContextService {

    private final TestParsingService testParsingService;
    private final AppContext appContext;
    private final ApplicationContext ctx;

    @Autowired
    public ContextServiceImpl(TestParsingService testParsingService, AppContext appContext, ApplicationContext ctx) {
        this.testParsingService = testParsingService;
        this.appContext = appContext;
        this.ctx = ctx;
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
    public GameStatistics getGameStatistics() {
        return appContext.getGameStatistics();
    }

    @Override
    public Optional<String> getTestFileName() {
        Pattern pattern = Pattern.compile("[\\\\/]([^\\\\/]*)$");
        Matcher matcher = pattern.matcher(appContext.getPathToTestFile());
        String name = null;
        if (matcher.find()) {
            name = matcher.group(1);
        }
        return Optional.ofNullable(name);
    }

    @Override
    public void setScoringStrategyName(String scoringStrategy) {
        appContext.setScoringStrategy(scoringStrategy);
    }

    @Override
    public Optional<String> getScoringStrategyName() {
        if (appContext.getScoringStrategy().equals("")) {
            return Optional.empty();
        }
        return Optional.of(appContext.getScoringStrategy());
    }

    @Override
    public Optional<ScoringStrategy> getScoringStrategy() {
        if (appContext.getScoringStrategy().equals("")) {
            return Optional.empty();
        }
        return ctx.getBeansOfType(ScoringStrategy.class)
                .values()
                .stream()
                .filter(v -> v.getName().equals(appContext.getScoringStrategy()))
                .findFirst();
    }

    @Override
    public void setQuestionChoiceStrategyName(String questionChoiceStrategy) {
        appContext.setQuestionChoiceStrategy(questionChoiceStrategy);
    }

    @Override
    public Optional<String> getQuestionChoiceStrategyName() {
        if (appContext.getQuestionChoiceStrategy().equals("")) {
            return Optional.empty();
        }
        return Optional.of(appContext.getQuestionChoiceStrategy());
    }

    @Override
    public Optional<QuestionChoiceStrategy> getQuestionChoiceStrategy() {
        if (appContext.getQuestionChoiceStrategy().equals("")) {
            return Optional.empty();
        }
        return ctx.getBeansOfType(QuestionChoiceStrategy.class)
                .values()
                .stream()
                .filter(v -> v.getName().equals(appContext.getQuestionChoiceStrategy()))
                .findFirst();
    }

    @Override public Optional<Question> getNextQuestion() {
        return Optional.ofNullable(appContext.getQuestionsQueue().poll());
    }

    @Override public void addToQuestionQueue(Question question) {
        appContext.getQuestionsQueue().add(question);
    }

    @Override public void addToQuestionQueue(Collection<? extends Question> questions) {
        appContext.getQuestionsQueue().addAll(questions);
    }

    public void resetToDefault() {
        appContext.getQuestionsQueue().clear();
        appContext.setQuestions(appContext.getTest().getQuestions());

        //TODO replace with GameStatistics.clear()
        appContext.setGameStatistics(new GameStatistics());
    }

    private void parseFile() {
        try {
            appContext.setTest(testParsingService.parse(appContext.getPathToTestFile()));
        } catch (ParseException e) {
            appContext.setTest(new Test(new ArrayList<>()));
        }
    }


}
