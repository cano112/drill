package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

import java.math.BigDecimal;

@Service
@Qualifier("fractionalWithSignScoringStrategy")
@Scope("singleton")
public final class FractionalWithSignStrategy extends BaseScoringStrategy {

    private static final String STRATEGY_NAME = "Fractional point";

    public FractionalWithSignStrategy() {
        super(false, true, true, BigDecimal.valueOf(1), BigDecimal.valueOf(-1), STRATEGY_NAME);
    }
}
