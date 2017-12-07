package pl.agh.edu.wiet.to2.kevin.config;

import javafx.stage.FileChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FxConfig {

    @Bean
    @Scope("prototype")
    FileChooser fileChooser() {
        return new FileChooser();
    }
}
