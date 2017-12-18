package pl.agh.edu.wiet.to2.kevin.service.questions.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.model.context.GameStatistics;
import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;

@Service
public class StatsServiceImpl implements StatsService {

    private final ContextService contextService;

    @Autowired
    public StatsServiceImpl(ContextService contextService) {
        this.contextService = contextService;
    }

    @Override public void applyChangeToContext(StatsChange statsChange) {
        addPoints(statsChange.getPoints());

        if (statsChange.isCorrect())
            incCorrectAnswers();
        else if (statsChange.isPartiallyCorrect())
            incPartiallyCorrectAnswers();
                else if (statsChange.isWrong())
            incWrongAnswers();

    }

    private void incCorrectAnswers() {
        GameStatistics gameStats = contextService.getGameStatistics();
        gameStats.setCorrectAnswers(gameStats.getCorrectAnswers() + 1);
    }

    private void incPartiallyCorrectAnswers() {
        GameStatistics gameStats = contextService.getGameStatistics();
        gameStats.setPartiallyCorrectAnswers(gameStats.getPartiallyCorrectAnswers() + 1);
    }

    private void incWrongAnswers() {
        GameStatistics gameStats = contextService.getGameStatistics();
        gameStats.setWrongAnswers(gameStats.getWrongAnswers() + 1);
    }

    private void addPoints(Double points) {
        GameStatistics gameStats = contextService.getGameStatistics();
        gameStats.setPoints(gameStats.getPoints() + points);
    }
}
