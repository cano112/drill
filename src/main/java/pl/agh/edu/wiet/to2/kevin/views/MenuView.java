package pl.agh.edu.wiet.to2.kevin.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.controllers.BaseController;
import pl.agh.edu.wiet.to2.kevin.fx.SpringFXMLLoader;

@Component @Qualifier("menuView")
public class MenuView extends View {

    public MenuView(ApplicationContext ctx) {
        super(ctx);
    }

    public void start(Stage stage) throws Exception {
        SpringFXMLLoader loader = new SpringFXMLLoader(getClass().getResource("/fxml/menu.fxml"), ctx);
        Scene scene = new Scene(loader.load(), 400, 200);
        ((BaseController)loader.getController()).setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
