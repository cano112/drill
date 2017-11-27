package pl.agh.edu.wiet.to2.kevin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App extends Application {

    @Autowired
    private AppContext appContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("pl.agh.edu.wiet.to2.kevin");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setControllerFactory(ctx::getBean);
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Drill");
        stage.setScene(scene);
        stage.show();
    }
}
