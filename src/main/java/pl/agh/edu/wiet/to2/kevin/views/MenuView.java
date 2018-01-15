package pl.agh.edu.wiet.to2.kevin.views;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.views.resolver.SpringFXMLLoader;

@Component @Scope("prototype") @Qualifier("menuView") public final class MenuView extends View {

    public MenuView(SpringFXMLLoader fxmlLoader) {
        super(fxmlLoader);
    }

    public void start(Stage stage) throws Exception {
        startView(stage, "/fxml/menu.fxml", 400, 200);
    }
}
