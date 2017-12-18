package pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies;

import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;

public abstract class BaseQuestionChoiceStrategy implements QuestionChoiceStrategy {

    protected final ContextService contextService;
    private String strategyName;

    public BaseQuestionChoiceStrategy(ContextService contextService, String strategyName) {
        this.contextService = contextService;
        this.strategyName = strategyName;
    }

    @Override public void initialize() {
        contextService.addToQuestionQueue(contextService.getQuestions());
    }

    @Override public String getName() {
        return strategyName;
    }
}
