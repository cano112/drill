package pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.BaseScoringStrategy;

@Service
@Qualifier("fractionalWithSignScoringStrategy")
@Scope("singleton")
public class FractionalWithSignStrategy extends BaseScoringStrategy {

    public FractionalWithSignStrategy() {
        super(false, true, true, 1, -1);
    }

    @Override
    public String getName() {
        return "Fractional point";
    }
}
