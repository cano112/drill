package pl.agh.edu.wiet.to2.kevin.fx;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;

import java.net.URL;

public class SpringFXMLLoader extends FXMLLoader {

    public SpringFXMLLoader(URL location, ApplicationContext ctx) {
        super(location);
        this.setControllerFactory(ctx::getBean);
    }
}
