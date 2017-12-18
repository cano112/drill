package pl.agh.edu.wiet.to2.kevin.views;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component @Qualifier("mainView")
public class MainView extends View {

    public MainView(ApplicationContext ctx) {
        super(ctx);
    }

    public void start(Stage stage) throws Exception {
        startView(stage, "/fxml/main.fxml", 600, 400);
    }
}
