package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

@Service
@Qualifier("zeroOnErrorScoringStrategy")
@Scope("singleton")
public class ZeroOnErrorStrategy extends BaseScoringStrategy {

    public ZeroOnErrorStrategy() {
        super(true, false, false, 1, 0);
    }

    @Override
    public String getName() {
        return "Zero on error";
    }
}
