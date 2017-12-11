package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

@Service
@Qualifier("pointForPointScoringStrategy")
@Scope("singleton")
public class PointForPointStrategy extends BaseScoringStrategy {

    public PointForPointStrategy() {
        super(false, true, false, 1, -1);
    }

    @Override
    public String getName() {
        return "Point for point";
    }
}
