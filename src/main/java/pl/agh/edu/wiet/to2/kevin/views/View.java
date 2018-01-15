package pl.agh.edu.wiet.to2.kevin.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agh.edu.wiet.to2.kevin.controllers.BaseController;
import pl.agh.edu.wiet.to2.kevin.views.resolver.SpringFXMLLoader;

public abstract class View {

    private final SpringFXMLLoader fxmlLoader;

    @Autowired public View(SpringFXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    public abstract void start(Stage stage) throws Exception;

    protected void startView(Stage stage, String resource, int width, int height) throws Exception {
        fxmlLoader.setLocation(getClass().getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        ((BaseController) fxmlLoader.getController()).setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
