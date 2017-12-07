package pl.agh.edu.wiet.to2.kevin.views.resolver;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.views.View;

@Component
public class ViewResolver {

    @Autowired
    private ApplicationContext ctx;

    public void showView(Stage stage, String viewName) {
        try {
            View view = (View) ctx.getBean(viewName);
            view.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
