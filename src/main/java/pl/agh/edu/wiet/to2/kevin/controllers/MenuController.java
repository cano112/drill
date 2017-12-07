package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.event.ActionEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class MenuController extends BaseController {

    public void onBrowseButtonClicked(ActionEvent actionEvent) {
        System.out.println("Browse file");
    }
}
