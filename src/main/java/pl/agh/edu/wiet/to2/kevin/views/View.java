package pl.agh.edu.wiet.to2.kevin.views;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public abstract class View {

    protected final ApplicationContext ctx;

    @Autowired
    public View(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public abstract void start(Stage stage) throws Exception;
}
