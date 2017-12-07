package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.service.context.MenuService;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;


@Controller
@Scope("prototype")
public class MenuController extends BaseController {

    private final MenuService menuService;
    private final ViewResolver viewResolver;

    @FXML
    private StringProperty fileName;

    @Autowired
    public MenuController(MenuService menuService, ViewResolver viewResolver) {
        this.menuService = menuService;
        this.viewResolver = viewResolver;

        this.fileName = new SimpleStringProperty();
    }

    public void onBrowseButtonClicked(ActionEvent actionEvent) {
        menuService.pickFile(getStage().orElse(new Stage()));
    }

    public void onStartButtonClicked(ActionEvent actionEvent) {
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
