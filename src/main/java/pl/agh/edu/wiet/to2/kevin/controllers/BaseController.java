package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.stage.Stage;

import java.util.Optional;

public abstract class BaseController {
    private Stage stage = null;

    public Optional<Stage> getStage() {
        return Optional.ofNullable(stage);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
