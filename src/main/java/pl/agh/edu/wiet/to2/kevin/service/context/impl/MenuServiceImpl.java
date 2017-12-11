package pl.agh.edu.wiet.to2.kevin.service.context.impl;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.context.MenuService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

import java.io.File;
import java.util.Observable;
import java.util.Optional;
import java.util.Set;

@Component
public class MenuServiceImpl implements MenuService {

    private final ContextService contextService;
    private final FileChooser fileChooser;
    private final ApplicationContext ctx;

    @Autowired
    public MenuServiceImpl(ContextService contextService, FileChooser fileChooser, ApplicationContext ctx) {
        this.contextService = contextService;
        this.fileChooser = fileChooser;
        this.ctx = ctx;
    }

    @Override
    public Optional<String> pickFile(Stage stage) {
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            contextService.setTest(file.getAbsolutePath());
        }
        return contextService.getTestFileName();
    }

    @Override
    public ObservableList<String> getScoringStrategies() {
        return FXCollections.observableArrayList(ctx.getBeansOfType(ScoringStrategy.class).keySet());
    }

    @Override
    public ObservableList<String> getQuestionChoiceStrategies() {
        return FXCollections.observableArrayList(ctx.getBeansOfType(QuestionChoiceStrategy.class).keySet());
    }
}
