package pl.agh.edu.wiet.to2.kevin.views.resolver;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.exceptions.ViewResolveException;
import pl.agh.edu.wiet.to2.kevin.views.View;

@Component
public class ViewResolver {

    private final ApplicationContext ctx;

    @Autowired public ViewResolver(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void showView(Stage stage, String viewName) {
        try {
            View view = (View) ctx.getBean(viewName);
            view.start(stage);
        } catch (Exception e) {
           throw new ViewResolveException("Cannot resolve view", e);
        }
    }
}
