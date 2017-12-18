package pl.agh.edu.wiet.to2.kevin.service.context;

import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.Optional;

public interface MenuService {
    Optional<String> pickFile(Stage stage);
    ObservableList<String> getScoringStrategies();
    ObservableList<String> getQuestionChoiceStrategies();

    void validate();
 }
