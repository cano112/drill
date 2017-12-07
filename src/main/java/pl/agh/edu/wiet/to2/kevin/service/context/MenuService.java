package pl.agh.edu.wiet.to2.kevin.service.context;

import javafx.stage.Stage;

import java.util.Optional;

public interface MenuService {
    Optional<String> pickFile(Stage stage);
}
