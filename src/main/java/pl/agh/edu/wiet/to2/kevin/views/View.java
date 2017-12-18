package pl.agh.edu.wiet.to2.kevin.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pl.agh.edu.wiet.to2.kevin.controllers.BaseController;
import pl.agh.edu.wiet.to2.kevin.fx.SpringFXMLLoader;

public abstract class View {

    protected final ApplicationContext ctx;

    @Autowired
    public View(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public abstract void start(Stage stage) throws Exception;

    protected void startView(Stage stage, String resource, int width, int height) throws Exception {
        SpringFXMLLoader loader = new SpringFXMLLoader(getClass().getResource(resource), ctx);
        Scene scene = new Scene(loader.load(), width, height);
        ((BaseController) loader.getController()).setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
