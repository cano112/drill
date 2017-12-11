package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.model.context.GameStatistics;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

@Controller
@Scope("prototype")
public class SummaryController extends BaseController {

    private final ContextService contextService;
    private final ViewResolver viewResolver;

    @FXML
    private ObjectProperty<GameStatistics> gameStatistics;

    @Autowired
    public SummaryController(ContextService contextService, ViewResolver viewResolver) {
        this.contextService = contextService;
        this.viewResolver = viewResolver;

        this.gameStatistics = new SimpleObjectProperty<>(new GameStatistics());
    }

    @FXML
    private void initialize() {
        gameStatistics.set(contextService.getGameStatistics());
    }

    public void onMenuButtonClicked(ActionEvent actionEvent) {
        contextService.resetToDefault();
        viewResolver.showView(getStage().orElse(new Stage()), "menuView");
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics.get();
    }
}

