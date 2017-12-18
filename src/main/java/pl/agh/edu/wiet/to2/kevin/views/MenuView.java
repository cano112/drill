package pl.agh.edu.wiet.to2.kevin.views;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component @Qualifier("menuView")
public class MenuView extends View {

    public MenuView(ApplicationContext ctx) {
        super(ctx);
    }

    public void start(Stage stage) throws Exception {
        startView(stage, "/fxml/menu.fxml", 400, 200);
    }
}
