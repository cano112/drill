package pl.agh.edu.wiet.to2.kevin.service.questions.stats;

import pl.agh.edu.wiet.to2.kevin.model.questions.stats.StatsChange;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;

public interface StatsService {
    void applyChangeToContext(StatsChange statsChange);

}
