package pl.agh.edu.wiet.to2.kevin.service.context.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.exceptions.questions.EmptyListException;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.context.MenuService;
import pl.agh.edu.wiet.to2.kevin.service.questions.choice.strategies.QuestionChoiceStrategy;
import pl.agh.edu.wiet.to2.kevin.service.questions.scoring.strategies.ScoringStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (file != null) {
            contextService.setTest(file.getAbsolutePath());
        }
        return contextService.getTestFileName();
    }

    @Override
    public ObservableList<String> getScoringStrategies() {
        List<String> names = new ArrayList<>();
        ctx.getBeansOfType(ScoringStrategy.class).forEach((k, v) -> names.add(v.getName()));
        return FXCollections.observableArrayList(names);
    }

    @Override
    public ObservableList<String> getQuestionChoiceStrategies() {
        List<String> names = new ArrayList<>();
        ctx.getBeansOfType(QuestionChoiceStrategy.class).forEach((k, v) -> names.add(v.getName()));
        return FXCollections.observableArrayList(names);
    }

    @Override public void validate() {
        if (contextService.getQuestions().size() == 0)
            throw new EmptyListException("Empty list: no questions parsed");
    }
}
