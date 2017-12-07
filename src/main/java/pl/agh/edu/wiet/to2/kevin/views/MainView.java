package pl.agh.edu.wiet.to2.kevin.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.controllers.BaseController;
import pl.agh.edu.wiet.to2.kevin.fx.SpringFXMLLoader;

@Component
public class MainView extends View {

    public MainView(ApplicationContext ctx) {
        super(ctx);
    }

    public void start(Stage stage) throws Exception {
        SpringFXMLLoader loader = new SpringFXMLLoader(getClass().getResource("/fxml/main.fxml"), ctx);


        Scene scene = new Scene(loader.load(), 600, 400);
        BaseController controller = loader.getController();
        controller.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
