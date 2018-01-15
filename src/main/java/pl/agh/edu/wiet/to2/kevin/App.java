package pl.agh.edu.wiet.to2.kevin;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.agh.edu.wiet.to2.kevin.controllers.ExceptionHandler;
import pl.agh.edu.wiet.to2.kevin.views.resolver.ViewResolver;

public abstract class App extends Application {

    private final ApplicationContext ctx;

    public App() {
        this.ctx = new AnnotationConfigApplicationContext("pl.agh.edu.wiet.to2.kevin");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler((ExceptionHandler) ctx.getBean("exceptionHandler"));
        ViewResolver viewResolver =(ViewResolver)ctx.getBean("viewResolver");
        viewResolver.showView(stage, "menuView");
    }
}
