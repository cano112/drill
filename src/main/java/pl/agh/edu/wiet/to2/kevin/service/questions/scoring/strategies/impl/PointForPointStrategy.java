package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

import java.math.BigDecimal;

@Service
@Qualifier("pointForPointScoringStrategy")
@Scope("singleton")
public final class PointForPointStrategy extends BaseScoringStrategy {

    private static final String STRATEGY_NAME = "Point for point";

    public PointForPointStrategy() {
        super(false, true, false, BigDecimal.valueOf(1), BigDecimal.valueOf(-1), STRATEGY_NAME);
    }
}
