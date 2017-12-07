package pl.agh.edu.wiet.to2.kevin;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;


@Component
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext("pl.agh.edu.wiet.to2.kevin");
        ViewResolver viewResolver =(ViewResolver)ctx.getBean("viewResolver");
        viewResolver.showView(stage, "menuView");
    }
}
