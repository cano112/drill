package pl.agh.edu.wiet.to2.kevin.views.resolver;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component @Scope("prototype") @Qualifier("fxmlLoader")
public class SpringFXMLLoader extends FXMLLoader {

    @Autowired public SpringFXMLLoader(ApplicationContext ctx) {
        this.setControllerFactory(ctx::getBean);
    }
}
