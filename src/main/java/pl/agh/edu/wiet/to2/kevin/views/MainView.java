package pl.agh.edu.wiet.to2.kevin.views;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.fx.SpringFXMLLoader;

@Component @Scope("prototype") @Qualifier("mainView")
public class MainView extends View {

    public MainView(SpringFXMLLoader fxmlLoader) {
        super(fxmlLoader);
    }

    public void start(Stage stage) throws Exception {
        startView(stage, "/fxml/main.fxml", 600, 400);
    }
}
