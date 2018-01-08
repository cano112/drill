package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

import java.math.BigDecimal;

@Service
@Qualifier("zeroOnErrorScoringStrategy")
@Scope("singleton")
public final class ZeroOnErrorStrategy extends BaseScoringStrategy {

    private static final String STRATEGY_NAME = "Zero on error";

    public ZeroOnErrorStrategy() {
        super(true, false, false, BigDecimal.valueOf(1), BigDecimal.valueOf(0), STRATEGY_NAME);
    }
}
