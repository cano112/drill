package pl.agh.edu.wiet.to2.kevin;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.agh.edu.wiet.to2.kevin.controllers.ExceptionHandler;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext("pl.agh.edu.wiet.to2.kevin");
        Thread.setDefaultUncaughtExceptionHandler((ExceptionHandler) ctx.getBean("exceptionHandler"));
        ViewResolver viewResolver =(ViewResolver)ctx.getBean("viewResolver");
        viewResolver.showView(stage, "menuView");
    }
}
