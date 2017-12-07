package pl.agh.edu.wiet.to2.kevin.service.context.impl;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.agh.edu.wiet.to2.kevin.model.context.AppContext;
import pl.agh.edu.wiet.to2.kevin.service.context.ContextService;
import pl.agh.edu.wiet.to2.kevin.service.context.MenuService;

import java.io.File;
import java.util.Optional;

@Component
public class MenuServiceImpl implements MenuService {

    private final ContextService contextService;
    private final FileChooser fileChooser;

    @Autowired
    public MenuServiceImpl(ContextService contextService, FileChooser fileChooser) {
        this.contextService = contextService;
        this.fileChooser = fileChooser;
    }

    @Override
    public Optional<String> pickFile(Stage stage) {
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            contextService.setTest(file.getAbsolutePath());
        }
        return contextService.getTestFileName();
    }
}
