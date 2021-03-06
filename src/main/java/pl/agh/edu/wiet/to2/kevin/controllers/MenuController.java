package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.context.MenuService;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;


@Controller
@Scope("prototype") public final class MenuController extends BaseController {

    private final MenuService menuService;
    private final ContextService contextService;
    private final ViewResolver viewResolver;

    @FXML
    private ChoiceBox<String> questionChoiceStrategyChoiceBox;

    @FXML
    private ChoiceBox<String> scoringStrategyChoiceBox;

    @FXML
    private StringProperty fileName;

    @FXML
    void initialize() {
        // initialize choice boxes
        scoringStrategyChoiceBox.setItems(menuService.getScoringStrategies());
        questionChoiceStrategyChoiceBox.setItems(menuService.getQuestionChoiceStrategies());

        // add listeners
        scoringStrategyChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> contextService
                        .setScoringStrategyName(newValue));

        questionChoiceStrategyChoiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
                        contextService.setQuestionChoiceStrategyName(newValue));

        // set fields with values from context
        fileName.set(contextService.getTestFileName().orElse(""));

        scoringStrategyChoiceBox.getSelectionModel()
                .select(contextService.getScoringStrategyName().orElse(menuService.getScoringStrategies().get(0)));

        questionChoiceStrategyChoiceBox.getSelectionModel().select(contextService.getQuestionChoiceStrategyName()
                .orElse(menuService.getQuestionChoiceStrategies().get(0)));
    }

    @Autowired
    public MenuController(MenuService menuService, ContextService contextService, ViewResolver viewResolver) {
        this.menuService = menuService;
        this.contextService = contextService;
        this.viewResolver = viewResolver;

        this.fileName = new SimpleStringProperty();
    }

    public void onBrowseButtonClicked(ActionEvent actionEvent) {
        setFileName(menuService.pickFile(getStage().orElse(new Stage())).orElse(""));
    }

    public void onStartButtonClicked(ActionEvent actionEvent) {
        menuService.validate();
        viewResolver.showView(getStage().orElse(new Stage()), "mainView");
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

}
