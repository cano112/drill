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
        GameStatistics gameStats = contextService.getGameStatistics();

        gameStats.addPoints(statsChange.getPoints());

        if(statsChange.isCorrect()) gameStats.incCorrectAnswers();
        else
            if(statsChange.isPartiallyCorrect()) gameStats.incPartiallyCorrectAnswers();
                else
                    if(statsChange.isWrong()) gameStats.incWrongAnswers();

    }
}
